package Editorial;
import java.util.Scanner;

public class SistemaEditorial {
    private static Editorial editorial = new Editorial();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    crearNuevoTexto();
                    break;
                case 2:
                    agregarEdiciones();
                    break;
                case 3:
                    buscarAutoresEInformacion();
                    break;
                case 4:
                    buscarEdicionesDeTexto();
                    break;
                case 5:
                    obtenerLocalizacionesDeEdicion();
                    break;
                case 6:
                    solicitarAprobacion();
                    break;
                case 7:
                    accederSeudonimosAutor();
                    break;
                case 8:
                    reabastecerTiendas();
                    break;
                case 9:
                    aceptarOfertasAgencias();
                    break;
                case 10:
                    verImpresionesVentas();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema Editorial ---");
        System.out.println("1. Crear Nuevo Texto");
        System.out.println("2. Agregar Ediciones a un Texto");
        System.out.println("3. Buscar Autores e Información");
        System.out.println("4. Buscar Ediciones de un Texto");
        System.out.println("5. Obtener Lista de Localizaciones de una Edición");
        System.out.println("6. Solicitar Aprobación de un Texto en Lista de Espera");
        System.out.println("7. Acceder a los Seudónimos del Autor");
        System.out.println("8. Reabastecer Tiendas");
        System.out.println("9. Aceptar Ofertas de Agencias");
        System.out.println("10. Ver Impresiones y Ventas Realizadas por Texto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearNuevoTexto() {
        System.out.println("\n--- Crear Nuevo Texto ---");
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("¿Qué tipo de texto es? (Libro / Poemario / Comic): ");
        String tipoTexto = scanner.nextLine();

        Autor autor;
        switch (tipoTexto.toLowerCase()) {
            case "libro":
                autor = new AutorLibro(nombreAutor, "Editorial de Ejemplo");
                break;
            case "poemario":
                autor = new AutorPoemas(nombreAutor);
                break;
            case "comic":
                autor = new AutorComic(nombreAutor);
                break;
            default:
                System.out.println("Tipo de texto no válido.");
                return;
        }

        System.out.print("Ingrese el país del texto: ");
        String pais = scanner.nextLine();
        System.out.print("Ingrese la ciudad de origen del texto (opcional): ");
        String ciudadOrigen = scanner.nextLine();
        System.out.print("Ingrese el número de impresiones del texto: ");
        int impresiones = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Texto texto = new Texto(autor, pais, ciudadOrigen, impresiones);
        editorial.solicitarAprobacion(texto);

        System.out.println("Nuevo texto creado y solicitado para aprobación correctamente.");
    }

    private static void agregarEdiciones() {
        System.out.println("\n--- Agregar Ediciones a un Texto ---");
        System.out.print("Ingrese el nombre del autor del texto: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("¿Qué tipo de texto es? (Libro / Poemario / Comic): ");
        String tipoTexto = scanner.nextLine();

        Autor autor;
        switch (tipoTexto.toLowerCase()) {
            case "libro":
                autor = new AutorLibro(nombreAutor, "Editorial de Ejemplo");
                break;
            case "poemario":
                autor = new AutorPoemas(nombreAutor);
                break;
            case "comic":
                autor = new AutorComic(nombreAutor);
                break;
            default:
                System.out.println("Tipo de texto no válido.");
                return;
        }

        System.out.print("Ingrese el país del texto: ");
        String pais = scanner.nextLine();

        Texto texto = null;
        for (Texto t : editorial.getTextosEnEspera()) {
            if (t.getAutor().getNombre().equalsIgnoreCase(nombreAutor) && t.getPais().equalsIgnoreCase(pais) && t.getAutor().getClass().getSimpleName().equalsIgnoreCase(tipoTexto)) {
                texto = t;
                break;
            }
        }

        if (texto == null) {
            System.out.println("No se encontró un texto que coincida con los datos ingresados.");
            return;
        }

        System.out.print("Ingrese el número de ediciones que desea agregar: ");
        int numEdiciones = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        for (int i = 0; i < numEdiciones; i++) {
            Edicion edicion = new Edicion(texto);
            System.out.print("Ingrese el país de la edición " + (i + 1) + ": ");
            String paisEdicion = scanner.nextLine();
            System.out.print("¿Está censurada la edición? (true / false): ");
            boolean censurado = scanner.nextBoolean();
            System.out.print("¿Está interpretada la edición? (true / false): ");
            boolean interpretado = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar el buffer de entrada

            edicion.agregarLocalizacion(new Localizacion(paisEdicion, censurado, interpretado));
            texto.agregarEdicion(edicion);
        }

        System.out.println("Ediciones agregadas correctamente al texto.");
    }

    private static void buscarAutoresEInformacion() {
        System.out.println("\n--- Buscar Autores e Información de las Editoriales ---");
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();

        for (Texto texto : editorial.getTextosEnEspera()) {
            if (texto.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                System.out.println("Autor: " + texto.getAutor().getNombre());
                System.out.println("País: " + texto.getPais());
                System.out.println("Ciudad de Origen: " + (texto.getCiudadOrigen() != null ? texto.getCiudadOrigen() : "No especificada"));
                if (texto.getAutor() instanceof AutorLibro) {
                    System.out.println("Editorial: " + ((AutorLibro) texto.getAutor()).getEditorial());
                }
                return;
            }
        }

        System.out.println("No se encontró un autor con ese nombre.");
    }

    private static void buscarEdicionesDeTexto() {
        System.out.println("\n--- Buscar Ediciones de un Texto ---");
        System.out.print("Ingrese el nombre del autor del texto: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("¿Qué tipo de texto es? (Libro / Poemario / Comic): ");
        String tipoTexto = scanner.nextLine();

        Autor autor;
        switch (tipoTexto.toLowerCase()) {
            case "libro":
                autor = new AutorLibro(nombreAutor, "Editorial de Ejemplo");
                break;
            case "poemario":
                autor = new AutorPoemas(nombreAutor);
                break;
            case "comic":
                autor = new AutorComic(nombreAutor);
                break;
            default:
                System.out.println("Tipo de texto no válido.");
                return;
        }

        System.out.print("Ingrese el país del texto: ");
        String pais = scanner.nextLine();

        Texto texto = null;
        for (Texto t : editorial.getTextosEnEspera()) {
            if (t.getAutor().getNombre().equalsIgnoreCase(nombreAutor) && t.getPais().equalsIgnoreCase(pais) && t.getAutor().getClass().getSimpleName().equalsIgnoreCase(tipoTexto)) {
                texto = t;
                break;
            }
        }

        if (texto == null) {
            System.out.println("No se encontró un texto que coincida con los datos ingresados.");
            return;
        }

        System.out.println("Ediciones del texto:");
        for (Edicion edicion : texto.getEdiciones()) {
            System.out.println("Edición: " + edicion);
            for (Localizacion localizacion : edicion.getLocalizaciones()) {
                System.out.println("País: " + localizacion.getPais() + ", Censurado: " + localizacion.isCensurado() + ", Interpretado: " + localizacion.isInterpretado());
            }
        }
    }

    private static void obtenerLocalizacionesDeEdicion() {
        System.out.println("\n--- Obtener Lista de Localizaciones de una Edición ---");
        System.out.print("Ingrese el nombre del autor del texto: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("¿Qué tipo de texto es? (Libro / Poemario / Comic): ");
        String tipoTexto = scanner.nextLine();

        Autor autor;
        switch (tipoTexto.toLowerCase()) {
            case "libro":
                autor = new AutorLibro(nombreAutor, "Editorial de Ejemplo");
                break;
            case "poemario":
                autor = new AutorPoemas(nombreAutor);
                break;
            case "comic":
                autor = new AutorComic(nombreAutor);
                break;
            default:
                System.out.println("Tipo de texto no válido.");
                return;
        }

        System.out.print("Ingrese el país del texto: ");
        String pais = scanner.nextLine();

        Texto texto = null;
        for (Texto t : editorial.getTextosEnEspera()) {
            if (t.getAutor().getNombre().equalsIgnoreCase(nombreAutor) && t.getPais().equalsIgnoreCase(pais) && t.getAutor().getClass().getSimpleName().equalsIgnoreCase(tipoTexto)) {
                texto = t;
                break;
            }
        }

        if (texto == null) {
            System.out.println("No se encontró un texto que coincida con los datos ingresados.");
            return;
        }

        System.out.println("Localizaciones de la edición:");
        for (Edicion edicion : texto.getEdiciones()) {
            System.out.println("Edición: " + edicion);
            for (Localizacion localizacion : edicion.getLocalizaciones()) {
                System.out.println("País: " + localizacion.getPais() + ", Censurado: " + localizacion.isCensurado() + ", Interpretado: " + localizacion.isInterpretado());
            }
        }
    }

    private static void solicitarAprobacion() {
        System.out.println("\n--- Solicitar Aprobación de un Texto en Lista de Espera ---");
        System.out.print("Ingrese el nombre del autor del texto: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("¿Qué tipo de texto es? (Libro / Poemario / Comic): ");
        String tipoTexto = scanner.nextLine();

        Autor autor;
        switch (tipoTexto.toLowerCase()) {
            case "libro":
                autor = new AutorLibro(nombreAutor, "Editorial de Ejemplo");
                break;
            case "poemario":
                autor = new AutorPoemas(nombreAutor);
                break;
            case "comic":
                autor = new AutorComic(nombreAutor);
                break;
            default:
                System.out.println("Tipo de texto no válido.");
                return;
        }

        System.out.print("Ingrese el país del texto: ");
        String pais = scanner.nextLine();

        Texto texto = null;
        for (Texto t : editorial.getTextosEnEspera()) {
            if (t.getAutor().getNombre().equalsIgnoreCase(nombreAutor) && t.getPais().equalsIgnoreCase(pais) && t.getAutor().getClass().getSimpleName().equalsIgnoreCase(tipoTexto)) {
                texto = t;
                break;
            }
        }

        if (texto == null) {
            System.out.println("No se encontró un texto que coincida con los datos ingresados.");
            return;
        }

        editorial.solicitarAprobacion(texto);
        System.out.println("Texto solicitado para aprobación correctamente.");
    }

    private static void accederSeudonimosAutor() {
        System.out.println("\n--- Acceder a los Seudónimos del Autor ---");
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();

        for (Texto texto : editorial.getTextosEnEspera()) {
            if (texto.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                System.out.println("Seudónimos del autor " + nombreAutor + ": " + texto.getAutor().getSeudonimos());
                return;
            }
        }

        System.out.println("No se encontró un autor con ese nombre.");
    }

    private static void reabastecerTiendas() {
        System.out.println("\n--- Reabastecer Tiendas ---");
        System.out.print("Ingrese el nombre de la tienda a reabastecer: ");
        String nombreTienda = scanner.nextLine();
        Tienda tienda = new Tienda(nombreTienda);

        // Suponiendo que aquí se añade el stock de libros a la tienda
        // En este caso, vamos a asumir que se agregan algunos libros a la tienda
        Autor autor = new AutorLibro("Autor de Libro de Ejemplo", "Editorial de Ejemplo");
        Texto libroEjemplo = new Texto(autor, "País de Ejemplo", "Ciudad de Ejemplo", 1000);
        tienda.agregarStockDisponible(libroEjemplo);

        System.out.println("Tienda reabastecida correctamente.");
    }

    private static void aceptarOfertasAgencias() {
        System.out.println("\n--- Aceptar Ofertas de Agencias ---");
        System.out.print("Ingrese el nombre de la agencia de librería: ");
        String nombreAgencia = scanner.nextLine();
        AgenciaLibreria agencia = new AgenciaLibreria(nombreAgencia);

        // Suponiendo que aquí se aceptan las ofertas de las agencias
        // En este caso, vamos a asumir que se aceptan todas las ofertas de la agencia
        for (Texto texto : editorial.getTextosEnEspera()) {
            editorial.aceptarOferta(agencia, new Tienda("Tienda de Ejemplo"), texto);
        }

        System.out.println("Ofertas de la agencia aceptadas correctamente.");
    }

    private static void verImpresionesVentas() {
        System.out.println("\n--- Ver Impresiones y Ventas Realizadas por Texto ---");
        System.out.print("Ingrese el nombre del autor del texto: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("¿Qué tipo de texto es? (Libro / Poemario / Comic): ");
        String tipoTexto = scanner.nextLine();

        Autor autor;
        switch (tipoTexto.toLowerCase()) {
            case "libro":
                autor = new AutorLibro(nombreAutor, "Editorial de Ejemplo");
                break;
            case "poemario":
                autor = new AutorPoemas(nombreAutor);
                break;
            case "comic":
                autor = new AutorComic(nombreAutor);
                break;
            default:
                System.out.println("Tipo de texto no válido.");
                return;
        }

        System.out.print("Ingrese el país del texto: ");
        String pais = scanner.nextLine();

        Texto texto = null;
        for (Texto t : editorial.getTextosEnEspera()) {
            if (t.getAutor().getNombre().equalsIgnoreCase(nombreAutor) && t.getPais().equalsIgnoreCase(pais) && t.getAutor().getClass().getSimpleName().equalsIgnoreCase(tipoTexto)) {
                texto = t;
                break;
            }
        }

        if (texto == null) {
            System.out.println("No se encontró un texto que coincida con los datos ingresados.");
            return;
        }

        editorial.verImpresionesYVentas(texto);
    }
}