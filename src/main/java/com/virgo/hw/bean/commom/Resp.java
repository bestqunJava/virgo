package com.virgo.hw.bean.commom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.virgo.hw.bean.enums.RespType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;


/**
 * javadoc virgo项目接口结果包裹类
 *
 * @author wang chenkai
 * @version 1.0.0
 * @date 2019/10/10 17:38
 */
@Data
@Accessors(chain = true)
public class Resp<T> {

    /**
     * 接口处理结果code标志, 默认情况下 0 成功, -1 失败, 其他情况下的交互互相协商即可
     **/
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer code;

    /**
     * 接口处理结果message标志, 默认情况下 success 或 处理成功 标志成功, error 或 处理失败 标志失败
     **/
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Result result;

    /**
     * 结构处理完成后需要返回的数据本身
     **/
    private T data;

    /**
     * 某些情况下需要额外携带一些交互值, 都在这个字段中
     * 注: 此字段被Jackson的注解标志, 为null的情况下不会参与到Json序列化, 既为null时接口返回值中无此字段
     **/
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Object extra;


    private Resp(){
    }

    private Resp(Integer code, String message, T data, Object extra){
        this.code = code;
        this.message = message;
        this.data = data;
        this.extra = extra;
    }

    /**
     * javadoc legal
     * @apiNote 验证内部接口之间互相调用返回的数据是否合法
     *
     * @param resp 接口返回结果
     * @return boolean
     * @author wang chenkai
     * @date 2020/1/13 16:55
     * @modified none
     */
    public static <T> boolean legal(Resp<T> resp){
        return Objects.nonNull(resp) && Objects.nonNull(resp.getCode()) && 0 == resp.getCode();
    }

    /**
     * javadoc legal
     * @apiNote 验证内部接口之间互相调用返回的数据是否合法
     *
     * @param resp 接口返回结果
     * @param code a given logic interface code
     * @return boolean
     * @author wang chenkai
     * @date 2020/1/13 16:55
     * @modified none
     */
    public static <T> boolean legal(Resp<T> resp, int code){
        return Objects.nonNull(resp) && Objects.nonNull(resp.getCode()) && code == resp.getCode();
    }

    public static <T> boolean legalWithResult(Resp<T> resp){
        return Objects.nonNull(resp) && Objects.nonNull(resp.getResult()) && Objects.nonNull(resp.getResult().getCode()) && 0 == resp.getResult().getCode();
    }

    public static <T> Resp<T> buildWithResult(Integer code, String message, T data){
        return new Resp<T>().setCode(code).setMessage(message).setResult(new Result().setCode(code).setMessage(message)).setData(data);
    }

    public static <T> Resp<T> buildWithResult(Result result, T data){
        return new Resp<T>().setResult(result).setData(data);
    }


    public static <T> Resp<T> build(Integer code, String message, T data) {
        final Result result = new Result(code, message, null);
        return new Resp<>(code, message, data, null).setResult(result);
    }

    /**
     * javadoc ok
     *
     * @return com.ws.leo.common.response.LeoResp<T>
     * @apiNote 某些特殊情况下 不需要返回数据实体, 只需要告知接口处理成功即可
     * @author wang chenkai
     * @date 2019/10/11 11:12
     * @modified none
     */
    public static <T> Resp<T> ok() {
        return new Resp<T>()
                .setCode(RespType.OK.getCode())
                .setMessage(RespType.OK.getMessage());
    }


    /**
     * javadoc ok
     *
     * @param data 需要返回的数据
     * @return com.ws.leo.common.response.LeoResp<T>
     * @apiNote 接口处理成功, 无需特殊处理code 及 message, 采用默认的成功code 及 message 去包裹data
     * @author wang chenkai
     * @date 2019/10/11 11:13
     * @modified none
     */
    public static <T> Resp<T> ok(T data) {
        return ok(RespType.OK.getCode(), RespType.OK.getMessage(), data, null);
    }

    /**
     * javadoc ok
     *
     * @param code 接口处理标识code
     * @param data 需要返回的数据
     * @return com.ws.leo.common.response.LeoResp<T>
     * @apiNote 接口处理成功, 但需要特殊的code
     * @author wang chenkai
     * @date 2019/10/11 11:14
     * @modified none
     */
    public static <T> Resp<T> ok(Integer code, T data) {
        return ok(code, RespType.OK.getMessage(), data, null);
    }




    /**
     * javadoc ok
     *
     * @param code    自定义code
     * @param message 自定义消息
     * @param data    返回的数据
     * @return com.ws.leo.common.response.LeoResp<T>
     * @apiNote 接口处理成功, 但是需要自定义的code 及 message 与前端交互
     * @author wang chenkai
     * @date 2019/10/11 11:18
     * @modified none
     */
    public static <T> Resp<T> ok(Integer code, String message, T data) {
        return ok(code, message, data, null);
    }

    /**
     * javadoc ok
     *
     * @param code    自定义code
     * @param message 自定义message
     * @param data    返回的data
     * @param extra   需要额外携带的交互数据
     * @return com.ws.leo.common.response.LeoResp<T>
     * @apiNote code message extra 全部自定义
     * @author wang chenkai
     * @date 2019/10/11 11:19
     * @modified none
     */
    public static <T> Resp<T> ok(Integer code, String message, T data, Object extra) {
        return new Resp<>(code, message, data, extra);
    }


    /**
     * javadoc error
     *
     * @param message 自定义error message
     * @return com.ws.leo.common.response.LeoResp<T>
     * @apiNote 接口处理异常 或者 逻辑异常
     * 采用默认的error code 及 自定义的error message 进行封装
     * @author wang chenkai
     * @date 2019/10/11 11:22
     * @modified none
     */
    public static <T> Resp<T> error(String message) {
        return new Resp<T>().setCode(RespType.ERROR.getCode()).setMessage(message);
    }
}
