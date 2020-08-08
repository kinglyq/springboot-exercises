package top.funsite.springboot.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.funsite.springboot.web.http.exception.*;

import java.util.Objects;

/**
 * 全局异常统一处理
 *
 * @author Li Yuqing
 * @date 2020-08-03 14:41:31
 * @see <a href="https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status" target="_blank">HTTP响应代码</a>
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String MESSAGE = "message";

    private static final String CAUSE = "cause";

    // 10.206.132.22:8080

    /**
     * 400 http请求数据解析异常
     *
     * @param e JsonParseException
     * @return Result
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ObjectNode> badRequest(Exception e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, "Problems parsing JSON")
                // TODO 是否写入系统堆栈错误信息
                .put(CAUSE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.BAD_REQUEST);
    }

    /**
     * 401 没有经过身份认证
     *
     * @param e e
     * @return Result
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ObjectNode> unauthorized(UnauthorizedException e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 403 无权限
     *
     * @param e e
     * @return Result
     */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ObjectNode> forbidden(ForbiddenException e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.FORBIDDEN);
    }

    /**
     * 404 资源不存在
     *
     * @param e NoHandlerFoundException
     * @return ErrorEntity
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ObjectNode> notFound(NoHandlerFoundException e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put("message", "Not Found")
                .put("httpMethod", e.getHttpMethod())
                .put("requestURL", e.getRequestURL());
        return new ResponseEntity<>(node, HttpStatus.NOT_FOUND);
    }

    /**
     * 422 参数校验错误
     *
     * @param e MethodArgumentNotValidException
     * @return ErrorEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ObjectNode> unprocessableEntity(Exception e) {
        String message = Objects.requireNonNull(((MethodArgumentNotValidException) e).getBindingResult().getFieldError()).getDefaultMessage();
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, message);
        return new ResponseEntity<>(node, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * 423 资源被锁定，禁止执行某些操作
     *
     * @param e MethodArgumentNotValidException
     * @return ErrorEntity
     */
    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ObjectNode> locked(LockedException e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.LOCKED);
    }

    /**
     * 429 用户在给定的时间内发送了太多请求（“限制请求速率”）
     *
     * @param e MethodArgumentNotValidException
     * @return ErrorEntity
     */
    @ExceptionHandler(TooManyRequestsException.class)
    public ResponseEntity<ObjectNode> tooManyRequests(TooManyRequestsException e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.TOO_MANY_REQUESTS);
    }

    /**
     * 451 用户请求非法资源，例如：由政府审查的网页
     *
     * @param e MethodArgumentNotValidException
     * @return ErrorEntity
     */
    @ExceptionHandler(UnavailableForLegalReasonsException.class)
    public ResponseEntity<ObjectNode> unavailableForLegalReasons(UnavailableForLegalReasonsException e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    /**
     * 捕获未知异常 500
     *
     * @param e Exception
     * @return ErrorEntity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ObjectNode> unknownException(Exception e) {
        ObjectNode node = OBJECT_MAPPER.createObjectNode()
                .put(MESSAGE, "Unknown error")
                // TODO 是否写入系统堆栈错误信息
                .put(CAUSE, e.getMessage());
        return new ResponseEntity<>(node, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
