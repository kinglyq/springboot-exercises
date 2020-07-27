package priv.lyq.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import priv.lyq.springboot.security.access.NoLoginAuthenticationEntryPoint;
import priv.lyq.springboot.security.access.NoPermissionDeniedHandler;
import priv.lyq.springboot.security.authentication.AuthenticationFilter;
import priv.lyq.springboot.security.authentication.AuthorizationFilter;

import javax.annotation.Resource;

/**
 * Spring Security配置
 *
 * @author Li Yuqing
 * @date 2020-05-24 09:33:00
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
       /* auth.inMemoryAuthentication() //认证信息存储到内存中
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("123456")).roles("admin");*/
    }

    /**
     * 忽略静态资源
     *
     * @param web {@link WebSecurity}
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/assets/**");
    }

    /**
     * 安全配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 排除的接口
        String[] permits = {
                "/login", "/open/**", "/h2/**"
        };
        http
                // 登录页面相关
                /* .formLogin(formLogin -> formLogin
                         .loginProcessingUrl("/login.html")
                         .usernameParameter("username")
                         .passwordParameter("password")
                         .permitAll()
                 )*/
                // 权限设置相关
                .authorizeRequests(authorize -> authorize
                                // authorTest 接口需要 admin_test 角色
                                // .antMatchers("/authorTest").hasRole("admin_test")
                                // permits下的请求任何人都可访问
                                .antMatchers(permits).permitAll()
                                // 未排除的所有请求必须经过身份验证方可使用
                                .anyRequest().authenticated()
                        // 所有请求可访问
                        // .anyRequest().permitAll()
                )
                // 登出相关
                /*.logout(logout -> logout
                                // 登出接口
                                .logoutUrl("/logout")
                        // .addLogoutHandler()
                )*/
                // 添加 JWT 登录拦截器
                .addFilter(new AuthenticationFilter(authenticationManager()))
                // 添加 JWT 鉴权拦截器
                .addFilter(new AuthorizationFilter(authenticationManager()))
                // session相关
                .sessionManagement(session -> session
                        // 设置Session的创建策略为：Spring Security永不创建HttpSession 不使用HttpSession来获取SecurityContext
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // CSRF请求限制无效
                .csrf(AbstractHttpConfigurer::disable)
                // 异常处理
                .exceptionHandling()
                // 匿名用户访问无权限资源时的异常
                .authenticationEntryPoint(new NoLoginAuthenticationEntryPoint())
                // 鉴权失败处理
                .accessDeniedHandler(new NoPermissionDeniedHandler())
                .and()
                .headers(header -> {
                    // 防止打不开h2控制台页面
                    header.frameOptions().disable();
                });
    }

    /**
     * 跨域配置
     *
     * @return 基于URL的跨域配置信息
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 注册跨域配置
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    /*public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

}
