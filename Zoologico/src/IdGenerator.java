public class IdGenerator {

        private static int animalIdCounter = 0;
        private static int visitanteIdCounter = 0;
        private static int empleadoIdCounter = 0;


        public static int generarIdAnimal() {
            return ++animalIdCounter;
        }

        public static int generarIdVisitante() {
            return ++visitanteIdCounter;
        }

        public static int generarIdEmpleado() {
            return ++empleadoIdCounter;
        }

    }


