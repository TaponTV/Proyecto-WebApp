package DataObjects.interfaces;

import models.Usuario;

public interface usuarioInterface extends GenericInterface<Usuario>{
	
	public Usuario showUser(int idUser);
	
}
