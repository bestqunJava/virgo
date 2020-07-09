package com.virgo.hw.bean.commom;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * javadoc 分页结果包裹
 *
 * @author w ck
 * @date 2019/10/10 18:40
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor()
@Data
@Accessors(chain = true)
public class PageData<T> {

    /**
     * 分页索引, 一般情况下int即可满足
     **/
    private int page;

    /**
     * 页元素大小, 不代表真是返回的数据大小, 是前端传过来的
     **/
    private int size;

    /**
     * 总页数, 少部分情况下pages可能超过int的范围, 所以定义成long
     *  比如: total 是long, size 为1, 那么pages会超出int的范围
     **/
    private long pages;

    /**
     * 数据总量
     **/
    private long total;

    /**
     * 数据本身
     **/
    private List<T> list;

    public static <T> PageData<T> empty(){
        return new PageData<>(1, 0, 0, 0, new ArrayList<>());
    }

    /**
     * javadoc page
     * @apiNote 查询无数据, 或者 逻辑处理出现异常无法取到数据时, 只返回页索引和页元素大小
     *
     * @param page 页索引
     * @param size 页元素大小
     * @return com.ws.leo.common.response.PageData<T>
     * @author weng xiaoyong
     * @date 2019/10/11 11:07
     * @modified none
     */
    public static <T> PageData<T> page(int page, int size){
        return new PageData<>(page, size, 0L, 0L, Lists.newArrayList());
    }

    /**
     * javadoc page
     * @apiNote 不需要计算总页数和总数的分页模式, 只需要返回当前页索引 页面元素大小 及 数据即可
     *
     * @param page 页索引
     * @param size 页面元素大小
     * @param data 数据
     * @return com.ws.leo.common.response.PageData<T>
     * @author weng xiaoyong
     * @date 2019/10/11 11:08
     * @modified none
     */
    public static <T> PageData<T> page(int page, int size, List<T> data){
        return page(page, size, 0L, data);
    }

    /**
     * javadoc page
     * @apiNote 手动count 后 手动分页的情况, 需要手动计算总页数
     *
     * @param page 页索引
     * @param size 页面元素大小
     * @param total 数据总数
     * @param data 本次查询返回的数据
     * @return com.ws.leo.common.response.PageData<T>
     * @author weng xiaoyong
     * @date 2019/10/11 11:09
     * @modified none
     */
    public static <T> PageData<T> page(int page, int size, long total, List<T> data){
        long ps = size > 0 ? total / size : 0;
        long de = size > 0 ? total % size : 0;
        if(de > 0){
            ps += 1;
        }
        return page(page, size, ps, total, data);
    }

    /**
     * javadoc page
     * @apiNote PageHelper已经完成好分页的情况, 传入数据包裹即可
     *
     * @param page 页索引
     * @param size 页大小
     * @param pages 总页数
     * @param total 数据总量
     * @param data 数据
     * @return com.ws.leo.common.response.PageData<T>
     * @author weng xiaoyong
     * @date 2019/10/11 11:10
     * @modified none
     */
    public static <T> PageData<T> page(int page, int size, long pages, long total, List<T> data){
        return new PageData<>(page, size, pages, total, data);
    }

    public static int defaultPage(Integer page){
        if (Objects.isNull(page) || page <= 0){
            return 1;
        }
        return page;
    }

    public static int defaultSize(Integer size){
        if (Objects.isNull(size) || size <= 0){
            return 20;
        }
        return size;
    }
}
