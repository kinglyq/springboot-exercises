package top.funsite.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.funsite.springboot.web.http.Result;

import java.util.Objects;

/**
 * 全局异常统一处理
 * <p>客户端错误: 400 - 发送无效的JSON； 422 - 参数校验错误</p>
 * <p>服务端错误: 500 - 异常</p>
 *
 * @author Li Yuqing
 * @date 2020-08-03 14:41:31
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerHandler {

    // 10.206.132.22:8080

    /**
     * http请求数据解析异常 400
     *
     * @param e JsonParseException
     * @return Result
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<Result> jsonParseException(Exception e) {
        Result result = new Result("Problems parsing JSON");
        // TODO 是否写入系统堆栈错误信息
        result.put("cause", e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    /**
     * 捕获404
     *
     * @param e NoHandlerFoundException
     * @return ErrorEntity
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Result> notFound(NoHandlerFoundException e) {
        Result result = new Result(e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    /**
     * 参数校验错误 422
     *
     * @param e MethodArgumentNotValidException
     * @return ErrorEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result> argumentException(MethodArgumentNotValidException e) {
        Result result = new Result(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * 捕获未知异常 500
     *
     * @param e Exception
     * @return ErrorEntity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> unknownException(Exception e) {
        return new ResponseEntity<>(new Result("Unknown error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
