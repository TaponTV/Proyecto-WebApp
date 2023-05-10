package DataObjects.interfaces;

import models.Usuario;

public interface usuarioInterface extends GenericInterface<Usuario>{
	
	public Usuario showUser(int idUser);
        public int validate(String str_e, String str_p);
        public int currentUser(int idUser);
	
}
