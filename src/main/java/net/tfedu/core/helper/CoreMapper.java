package net.tfedu.core.helper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Mapper<T>必不可少
 * 
 * @author Bruce
 *
 * @param <T>
 */
public interface CoreMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
