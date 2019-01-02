package com.ths.lxc.web.datasource;

/**
 * 数据源选择
 */
public class DataSourceSwitch {
	/** 当前需要的数据源类型 **/
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * 重置需要的数据源类型
	 * 
	 * @param dataSourceType 数据源类型
	 */
	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	/**
	 * 获取数据源类型
	 */
	public static String getDataSourceType() {
		return (String) contextHolder.get();
	}

	/**
	 * 移除数据源
	 */
	public static void clearDataSourceType() {
		contextHolder.remove();
	}

}
