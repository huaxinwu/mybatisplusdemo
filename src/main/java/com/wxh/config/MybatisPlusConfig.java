package com.wxh.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MybatisPlusConfig
 * @Description: mybatis plus配置类
 * @Author wxh
 * @Date: 2020/7/13 15:53
 * @Version V1.0.0
 * @Since 1.8
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     * @return PerformanceInterceptor 性能拦截器对象
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }

    /**
     *  mybatis-plus 分页插件
     * @return PaginationInterceptor 分页拦截器对象
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
