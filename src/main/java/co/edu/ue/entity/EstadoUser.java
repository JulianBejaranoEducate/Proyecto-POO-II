package co.edu.ue.entity;

public class EstadoUser {
	 
    public enum Estado {
        INACTIVO(0),
        ACTIVO(1);   

        private final int codigo;

        Estado(int codigo) {
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

        public static Estado fromCodigo(int codigo) {
            for (Estado estado : Estado.values()) {
                if (estado.getCodigo() == codigo) {
                    return estado;
                }
            }
            throw new IllegalArgumentException("Código inválido: " + codigo);
        }
    }
}
