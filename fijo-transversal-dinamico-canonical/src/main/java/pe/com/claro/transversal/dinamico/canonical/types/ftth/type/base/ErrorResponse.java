package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.ErrorType;

public class ErrorResponse {
	private ErrorType error;
	public ErrorType getError() {
		return error;
	}
	public void setError(ErrorType error) {
		this.error = error;
	}
}
