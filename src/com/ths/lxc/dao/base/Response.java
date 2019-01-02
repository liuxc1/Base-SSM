package com.ths.lxc.dao.base;

public class Response {
	private final static String OK = "ok";
	private final static String ERROR = "error";

	/**基本信息**/
	private Meta meta;
	/**返回数据**/
	private Object data;

	/**
	 * 成功返回
	 * @param data 返回数据
	 * @return
	 */
	public Response success(Object data) {
		this.meta = new Meta(true, OK);
		this.data = data;
		return this;
	}

	/**
	 * 失败返回
	 * @return
	 */
	public Response failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	/**
	 * 失败返回
	 * @param message 失败信息
	 * @return
	 */
	public Response failure(String message) {
		this.meta = new Meta(false, message);
		return this;
	}

	public Meta getMeta() {
		return meta;
	}

	public Object getData() {
		return data;
	}
	
	/**
	 * 内部类，作为基础信息
	 * @author liangdl
	 */
	public class Meta {
		/** 是否成功 **/
		private boolean success;
		/** 消息 **/
		private String message;

		/**
		 * 构造方法
		 * @param success 是否成功
		 * @param message 消息
		 */
		public Meta(boolean success, String message) {
			super();
			this.success = success;
			this.message = message;
		}

		/**
		 * 构造方法
		 * @param success 是否成功
		 */
		public Meta(boolean success) {
			super();
			this.success = success;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}