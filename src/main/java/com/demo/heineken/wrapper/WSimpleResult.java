package com.demo.heineken.wrapper;


public class WSimpleResult extends WSpaces{
	
	private WStatus status;

	
	public WSimpleResult(String statuscadena){
		super(statuscadena);
		createStatus();
	}

	public WStatus getStatus() {
		return status;
	}

	public void setStatus(WStatus status) {
		this.status = status;
	}

	private void createStatus(){
		if(separated != null && !separated.isEmpty()){			
			if(separated.get(0).equals("Error")||separated.get(0).equals("error")){
				String idError;
				if(separated.size() > 2) {
					idError = separated.get(1).trim();
					setStatus(new WStatus(separated.get(0).trim(),idError,separated.get(2).trim()));
				} else {
					idError = WResponse.ERROR_REGISTRO;
					setStatus(new WStatus(separated.get(0).trim(),idError,separated.get(1).trim()));
				}				
			}
			else
				if(separated.get(0).equals("Ok")||separated.get(0).equals("ok")||separated.get(0).equals("OK") ){
					setStatus(new WStatus(OK_REGISTRO,ID_OK_REGISTRO,MESSAGE_OK_REGISTRO));
				}
				else{
					if(separated.get(0).equals("UsuarioExiste")||separated.get(0).equals("usuarioexiste")||separated.get(0).equals("USUARIOEXISTE")){
					setStatus(new WStatus(ERROR_REGISTRO,ID_ERROR_REGISTRO,MESSAGE_ERROR_REGISTRO));
					}
					else{
						setStatus(new WStatus(ERROR,ID_INTERNAL_ERROR,MESSAGE_INTERNAL_ERROR));
					}
					if(separated.get(0).equals("emailexistente")){
						setStatus(new WStatus(ERROR_REGISTRO_EMAIL,ID_ERROR_REGISTRO_EMAIL,MESSAGE_ERROR_REGISTRO_EMAIL));
					}
				}
				if(separated.get(0).equals("PagoTarjetaOK")){
					setStatus(new WStatus(OK_TARJETA,ID_OK_TARJETA,MESSAGE_OK_TARJETA));
				}
				else{
					if(separated.get(0).equals("PagoPaypalOK")){
					setStatus(new WStatus(OK_PAYPAL,ID_OK_PAYPAL,MESSAGE_OK_PAYPAL));
					}
					/*else{
						setStatus(new WStatus(ERROR,ID_INTERNAL_ERROR,MESSAGE_INTERNAL_ERROR));
					}*/
				}
				if(separated.get(0).equals("PedidoOk")){
					setStatus(new WStatus(OK_PEDIDO,ID_OK_PEDIDO,MESSAGE_OK_PEDIDO));
				}
				if(separated.get(0).equals("LoginOk")){
					setStatus(new WStatus(OK_LOGIN,ID_OK_LOGIN,MESSAGE_OK_LOGIN));
				}else{
					if(separated.get(0).equals("wrongpass")){
						setStatus(new WStatus(ERROR_LOGIN_PASS,ID_ERROR_LOGIN_PASS,MESSAGE_ERROR_LOGIN_PASS));
					}else{
						if(separated.get(0).equals("usuarionoexiste")){
							setStatus(new WStatus(ERROR_LOGIN_USER,ID_ERROR_LOGIN_USER,MESSAGE_ERROR_LOGIN_USER));
						}else{
							if(separated.get(0).equals("sesionabierta")){
								setStatus(new WStatus(ERROR_LOGIN_LOG,ID_ERROR_LOGIN_LOG,MESSAGE_ERROR_LOGIN_LOG));
							}
						}
					}
				}
				if(separated.get(0).equals("LogoutOk")){
					setStatus(new WStatus(OK_LOGOUT, ID_OK_LOGOUT, MESSAGE_OK_LOGOUT));
				}
				if(separated.get(0).equals("SessionTimeOut")){
					setStatus(new WStatus(ERROR_SESSION_TIMEOUT, ID_ERROR_SESSION_TIMEOUT, MESSAGE_ERROR_SESSION_TIMEOUT));
				}
				if(separated.get(0).equals("NoLogin")){
					setStatus(new WStatus(ERROR_NO_LOGIN, ID_ERROR_NO_LOGIN, MESSAGE_ERROR_NO_LOGIN));
				}
				if(separated.get(0).equals("OkAddItem")){
					setStatus(new WStatus(OK_ADDITEM, ID_OK_ADDITEM, MESSAGE_OK_ADDITEM));
				}
				if(separated.get(0).equals("OkItems")){
					setStatus(new WStatus(OK_GETITEMS, ID_OK_GETITEMS, MESSAGE_OK_GETITEMS));
				}else{
					if(separated.get(0).equals("NoHay")){
						setStatus(new WStatus(ERROR_NOHAY_ITEMS, ID_ERROR_NOHAY_ITEMS, MESSAGE_ERROR_NOHAY_ITEMS));
					}
				}
				if(separated.get(0).equals("OkVal")){
					setStatus(new WStatus(OK_VALIDA, ID_OK_VALIDA, MESSAGE_OK_VALIDA));
				}
				if(separated.get(0).equals("OkEmail")){
					setStatus(new WStatus(OK_EMAIL, ID_OK_EMAIL, MESSAGE_OK_EMAIL));
				}else{
					if(separated.get(0).equals("NoUserByEmail")){
						setStatus(new WStatus(ERROR_NOEAMIL, ID_ERROR_NOEAMIL, MESSAGE_ERROR_NOEAMIL));
					}else{
						if(separated.get(0).equals("NoUserByUserName"))
							setStatus(new WStatus(ERROR_NOUSERNAME, ID_ERROR_NOUSERNAME, MESSAGE_ERROR_NOUSERNAME));
					}
				}
				if(separated.get(0).equals("OkAddAba")){
					setStatus(new WStatus(OK_ADD_ABA, ID_OK_ADD_ABA, MESSAGE_OK_ADD_ABA));
				}
				if(separated.get(0).equals("OkBC")){
					setStatus(new WStatus(OK_CART, ID_OK_CART, MESSAGE_OK_CART));
				}
				if(separated.get(0).equals("OkDC")){
					setStatus(new WStatus(OK_DCART, ID_OK_DCART, MESSAGE_OK_DCART));
				}
				if(separated.get(0).equals("OkGCI")){
					setStatus(new WStatus(OK_GETITEMS, ID_OK_GETITEMS, MESSAGE_OK_GETITEMS));
				}
				if(separated.get(0).equals("OkOC")){
					setStatus(new WStatus(OK_OCART, ID_OK_ODCART, MESSAGE_OK_OCART));
				}
				if(separated.get(0).equals("OkUpdate")){
					setStatus(new WStatus(OK_UPDATE, ID_OK_UPDATE, MESSAGE_OK_UPDATE));
				}
				
				
				
				
				
			
		}
		else{
			setStatus(new WStatus(ERROR,ID_INTERNAL_ERROR,MESSAGE_INTERNAL_ERROR));
		}
		
	}

}
