package com.example.library.app.exception;


public class LibraryException {

		private String errorMsg;
		private String httpStatus;
		
		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}
		public String getHttpStatus() {
			return httpStatus;
		}
		public void setHttpStatus(String httpStatus) {
			this.httpStatus = httpStatus;
		}
		
		
		public LibraryException(String errorMsg) {
			super();
			this.errorMsg = errorMsg;
		}
		
		
		
}
