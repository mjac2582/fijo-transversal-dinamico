package pe.com.claro.transversal.dinamico.canonical.comun.bean;

import java.io.Serializable;

public class ReqResTransporte<T>  extends ReqResTransporteBase  implements Serializable{
	private static final long serialVersionUID = 1L;
	private T headerRequest;
	private T bodyRequest;
	private T headerResponse;
	private T bodyResponse;
	private T errorResponse;
	private Class<?> clzResponse;
	private Class<?> clzError;
	
	public ReqResTransporte(T hRequest, T bRequest, T hResponse, Class<?> clzResponse, Class<?> clzError) {
		headerRequest=hRequest;
		bodyRequest=bRequest;
		headerResponse=hResponse;
		this.clzResponse=clzResponse;
		this.clzError =clzError;
	}
	public ReqResTransporte(T hRequest, T bRequest, Class<?> clzResponse, Class<?> clzError) {
		headerRequest=hRequest;
		bodyRequest=bRequest;
		this.clzResponse=clzResponse;
		this.clzError =clzError;
	}
	public ReqResTransporte(T bRequest, Class<?> clzResponse, Class<?> clzError) {
		bodyRequest=bRequest;
		this.clzResponse=clzResponse;
		this.clzError =clzError;
	}
	public ReqResTransporte(T bRequest, Class<?> clzResponse) {
		bodyRequest=bRequest;
		this.clzResponse=clzResponse;
	}
	
	
	public ReqResTransporte(T bRequest) {
		bodyRequest=bRequest;
	}
	
	
	public ReqResTransporte() {}
	public void  request(T h, T b) {
		headerRequest = h;
		bodyRequest = b;
	}
	public void  response(Class<?> clzResponse) {
		this.clzResponse = clzResponse;
	}
	public void  response(T h, Class<?> clzResponse) {
		headerResponse = h;
		this.clzResponse = clzResponse;
	}
	public void  response(T h, Class<?> clzResponse, Class<?> clzError) {
		headerResponse = h;
		this.clzResponse = clzResponse;
		this.clzError = clzError;
	}
	public T getBodyRequest() {
		return bodyRequest;
	}
	public void setBodyRequest(T bodyRequest) {
		this.bodyRequest = bodyRequest;
	}
	public T getHeaderResponse() {
		return headerResponse;
	}
	public void setHeaderResponse(T headerResponse) {
		this.headerResponse = headerResponse;
	}
	public T getBodyResponse() {
		return bodyResponse;
	}
	public void setBodyResponse(T bodyResponse) {
		this.bodyResponse = bodyResponse;
	}
	public T getHeaderRequest() {
		return headerRequest;
	}
	public void setHeaderRequest(T headerRequest) {
		this.headerRequest = headerRequest;
	}
	public Class<?> getClzResponse() {
		return clzResponse;
	}
	public void setClzResponse(Class<?> clzResponse) {
		this.clzResponse = clzResponse;
	}
	public Class<?> getClzError() {
		return clzError;
	}
	public void setClzError(Class<?> clzError) {
		this.clzError = clzError;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public T getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(T errorResponse) {
		this.errorResponse = errorResponse;
	}

}
