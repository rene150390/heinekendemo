package com.demo.heineken.wrapper;

public class WResponse {
	
	//String constants for OK
	public final static String OK = "Ok";
	public final static String ID_OK = "00";
	public final static String MESSAGE_OK = "Todo Correcto";
	
	//String constants for OK_REGISTRO
	public final static String OK_REGISTRO = "RegistroOK";
	public final static String ID_OK_REGISTRO = "00";
	public final static String MESSAGE_OK_REGISTRO = "Exito. Su usuario ha quedado registrado";
	
	//String constants for OK_REGISTRO
	public final static String OK_TARJETA = "PagoTarjetaOK";
	public final static String ID_OK_TARJETA = "00";
	public final static String MESSAGE_OK_TARJETA = "Pago con Tarjeta";
	
	//String constants for OK_REGISTRO
	public final static String OK_PAYPAL = "PagoPaypalOK";
	public final static String ID_OK_PAYPAL = "00";
	public final static String MESSAGE_OK_PAYPAL = "Pago con Paypal";
	
	//String constants for OK_PEDIDO
	public final static String OK_PEDIDO = "PedidoOK";
	public final static String ID_OK_PEDIDO = "00";
	public final static String MESSAGE_OK_PEDIDO = "Pedido";
	
	//String login OK
	public final static String OK_LOGIN = "LoginOk";
	public final static String ID_OK_LOGIN = "00";
	public final static String MESSAGE_OK_LOGIN = "¡ Bienvenido !";
	
	//String login Error Password
	public final static String ERROR_LOGIN_PASS = "wrongpass";
	public final static String ID_ERROR_LOGIN_PASS= "07";
	public final static String MESSAGE_ERROR_LOGIN_PASS = "Password Incorrecto.";
	
	//String login Error user
	public final static String ERROR_LOGIN_USER = "usuarionoexiste";
	public final static String ID_ERROR_LOGIN_USER= "08";
	public final static String MESSAGE_ERROR_LOGIN_USER = "Usuario inexistente.";
	
	//String login already loged
	public final static String ERROR_LOGIN_LOG = "sesionabierta";
	public final static String ID_ERROR_LOGIN_LOG= "09";
	public final static String MESSAGE_ERROR_LOGIN_LOG = "Ya has iniciado sesión en otro lugar.";
	
	//String login already loged
	public final static String OK_LOGOUT = "LogoutOk";
	public final static String ID_OK_LOGOUT= "00";
	public final static String MESSAGE_OK_LOGOUT = "Has cerrado sesion correctamente.";
	
	//
	public final static String OK_GETITEMS = "OKgetitems";
	public final static String ID_OK_GETITEMS= "00";
	public final static String MESSAGE_OK_GETITEMS = "Lista de productos.";
	
	//
	public final static String ERROR_NOHAY_ITEMS = "NoHayItems";
	public final static String ID_ERROR_NOHAY_ITEMS= "13";
	public final static String MESSAGE_ERROR_NOHAY_ITEMS = "No hay productos registrados en esta categoría.";
	
	//String login already loged
	public final static String OK_ADDITEM = "ItemAddedOk";
	public final static String ID_OK_ADDITEM= "00";
	public final static String MESSAGE_OK_ADDITEM = "Se ha agregado correctamente.";
	
	//String Session Timeout
	public final static String ERROR_SESSION_TIMEOUT = "SessionTimeOut";
	public final static String ID_ERROR_SESSION_TIMEOUT= "11";
	public final static String MESSAGE_ERROR_SESSION_TIMEOUT = "El tiempo de la sesion se ha terminado.";
	
	//String No login 
	public final static String ERROR_NO_LOGIN = "NoLogin";
	public final static String ID_ERROR_NO_LOGIN= "12";
	public final static String MESSAGE_ERROR_NO_LOGIN = "No has iniciado sesion, para esta operacion.";
	
	//String email existente
	public final static String ERROR_REGISTRO_EMAIL = "emailyaexiste";
	public final static String ID_ERROR_REGISTRO_EMAIL= "14";
	public final static String MESSAGE_ERROR_REGISTRO_EMAIL = "El email de usuario ya existe.";
		
	
	//String contants for Error, user already exists
	public final static String ERROR_REGISTRO = "ErrorRegistroUsuarioExistente";
	public final static String ID_ERROR_REGISTRO = "02";
	public final static String MESSAGE_ERROR_REGISTRO= "El nombre de Usuario ya existe";
	
	//String contants for Error
	public final static String ERROR = "Error";
	public final static String ID_INTERNAL_ERROR = "100";
	public final static String MESSAGE_INTERNAL_ERROR = "Error interno del servidor";
	
	//String validate OK
	public final static String OK_VALIDA = "OkValida";
	public final static String ID_OK_VALIDA= "00";
	public final static String MESSAGE_OK_VALIDA = "Validacion Ok.";
	
	//String email OK
	public final static String OK_EMAIL = "OkEmail";
	public final static String ID_OK_EMAIL= "00";
	public final static String MESSAGE_OK_EMAIL = "El correo de recuperación de password ha sido enviado satisfactoriamente.";
	
	//String no email registered
	public final static String ERROR_NOEAMIL = "NoUserByEmail";
	public final static String ID_ERROR_NOEAMIL= "15";
	public final static String MESSAGE_ERROR_NOEAMIL = "El email no está registrado.";
	
	//String no username registered
	public final static String ERROR_NOUSERNAME = "NoUserByUserName";
	public final static String ID_ERROR_NOUSERNAME= "16";
	public final static String MESSAGE_ERROR_NOUSERNAME = "Nombre de usuario no registado.";
	
	//String agregar Abarrote OK
	public final static String OK_ADD_ABA = "OkAddAba";
	public final static String ID_OK_ADD_ABA= "00";
	public final static String MESSAGE_OK_ADD_ABA = "Has agregado un Abarrote/Servicio.";
	
	//String construir carrito Abarrote OK
	public final static String OK_CART = "OkBC";
	public final static String ID_OK_CART = "00";
	public final static String MESSAGE_OK_CART = "Has creado el carrito decompras.";
	
	//String construir carrito de compras OK
	public final static String OK_DCART = "OkDC";
	public final static String ID_OK_DCART = "00";
	public final static String MESSAGE_OK_DCART = "Has eliminado un producto del carrito de compras.";
	
	//String construir carrito de compras OK
	public final static String OK_OCART = "OkOC";
	public final static String ID_OK_ODCART = "00";
	public final static String MESSAGE_OK_OCART = "Has cambiado o sobrescrito la cantidad de un producto.";
	
	//String actualizar cliente de compras OK
	public final static String OK_UPDATE = "OkUpdate";
	public final static String ID_OK_UPDATE = "00";
	public final static String MESSAGE_OK_UPDATE = "Has actualizado tu información.";
	

	
	public WResponse() {
		
	}
	
	String[] splitBySpaces(String cadena){
		return cadena.split("\\|");
	}
}
