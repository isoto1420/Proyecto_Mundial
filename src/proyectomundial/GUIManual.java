package proyectomundial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class GUIManual extends JFrame {
    // Matrix que permite almancenar la información de las selecciones futbol cargadas

    public String[][] selecciones = null;

    // Matrix que permite almancenar la información de las selecciones futbol cargadas
    public String[][] seleccionesFiltro = null;
    public String[][] resultadosFiltro = null;
    // Matriz que permite almacenar los resultados de los partidos cargardos
    public String[][] resultados = null;

    // Elementos de bara Lateral
    private JPanel jPanelLeft;

    private JPanel jPanelIconFIFA;
    private JLabel iconFIFA;

    // Elementos de opciones de Menú
    private JPanel jPanelMenu;

    private JPanel jPanelMenuHome;
    private JLabel btnHome;

    private JPanel jPanelMenuSelecciones;
    private JLabel btnSelecciones;

    private JPanel jPanelMenuResultados;
    private JLabel btnResultados;

    private JPanel jPanelMenuDashboardSel;
    private JLabel btnDashboardSel;

    private JPanel jPanelMenuDashboardRes;
    private JLabel btnDashboardRes;
    private JPanel japanelmatrix;
    private JLabel botonmatrizx;

    // Elementos de panel de contenido
    private JPanel jPanelRight;
    private JPanel jPanelLabelTop;
    private JLabel jLabelTop;

    private JPanel jPanelMain;
    public JButton CantDT = new JButton();
    public JButton Continentes1 = new JButton();
    public JButton NacionalidadDT = new JButton();
    public JPanel panelBotones = new JPanel();
    public String[][] Matriz = new String[5][2];
    public int contador1 = 0;
    public int contador2 = 0;
    public int contador3 = 0;
    public int contador4 = 0;
    public int contador5 = 0;

    public GUIManual() {

        // Se inician los componentes gráficos
        initComponents();

        // Se configuran propiedades de nuestra Ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Se llama la función home para que al momento de iniciar la aplicacoón, por defecto se muestre el home
        accionHome();

    }

    private void initComponents() {

        // Inicializamos componentes del Menu Lateral
        jPanelLeft = new JPanel();

        jPanelIconFIFA = new JPanel();
        iconFIFA = new JLabel();
        jPanelMenu = new JPanel();

        jPanelMenuHome = new JPanel();
        btnHome = new JLabel();

        jPanelMenuSelecciones = new JPanel();
        btnSelecciones = new JLabel();

        jPanelMenuResultados = new JPanel();
        btnResultados = new JLabel();

        jPanelMenuDashboardSel = new JPanel();
        btnDashboardSel = new JLabel();

        jPanelMenuDashboardRes = new JPanel();
        btnDashboardRes = new JLabel();
        japanelmatrix = new JPanel();
        botonmatrizx = new JLabel();

        // Pinta el logo de la aplicación
        pintarLogo();

        // Pinta la opción de menú del Home
        pintarMenuHome();

        // Pinta la opción de Menú de las Selecciones
        pintarMenuSelecciones();

        // Pinta la opción de Menú de los resultados
        pintarMenuResultados();

        // Pinta la opción de Menú del dashboard de equipo
        pintarMenuDashboardSel();

        // Pinta la opción de Menú del dahboard de resultados
        pintarMenuDashboardRes();
        botonmatrizx();

        // Pinta y ajuste diseño del contenedor del panel izquierdo
        pintarPanelIzquierdo();

        // Inicializa los componentes del panel derecho de los contenidos
        jPanelRight = new JPanel();
        jPanelLabelTop = new JPanel();
        jPanelMain = new JPanel();

        // Pinta la barra superrior de color azul claro, del panel de contenido
        pintarLabelTop();

        // Pinta y ajusta diseño del contenedor de contenidos
        pintarPanelDerecho();

        setTitle("Mundial");
        pack();
        setVisible(true);
    }

    private void pintarLogo() {
        jPanelIconFIFA.add(iconFIFA);
        jPanelIconFIFA.setOpaque(false);
        jPanelIconFIFA.setPreferredSize((new java.awt.Dimension(230, 80)));
        jPanelIconFIFA.setMaximumSize(jPanelIconFIFA.getPreferredSize());
        iconFIFA.setIcon(new ImageIcon(getClass().getResource("/resources/world-cup-366713_1280.jpg")));
        jPanelLeft.add(jPanelIconFIFA, BorderLayout.LINE_START);

    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación del HOME Define estilos, etiquetas, iconos que
     * decoran la opción del Menú. Esta opción de Menu permite mostrar la página
     * de bienvenida de la aplicación
     */
    private void pintarMenuHome() {
        btnHome.setIcon(new ImageIcon(getClass().getResource("/resources/icons/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioHome = new JLabel();
        jPanelMenuHome.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuHome.setPreferredSize((new java.awt.Dimension(220, 45)));
        jPanelMenuHome.setLayout(new BorderLayout(15, 0));
        jPanelMenuHome.add(vacioHome, BorderLayout.WEST);
        jPanelMenuHome.add(btnHome, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuHome);

        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Home");
                if (contador1 == 10) {
                    JOptionPane.showMessageDialog(null, "haz alcanzado el limite de visitas ");
                } else {
                    contador1--;
                }
                accionHome();
            }
        });
    }

    /**
     * Función que se ejecuta cuando el usuario hacer click sobre la opción de
     * navegación Home Permite modificar la etiqueta de Navegación en Home,
     * remover los elementos que hay en el panel de contenidos y agregar la
     * imagen de inicio de la aplicación
     */
    private void accionHome() {

        jLabelTop.setText("Home");
        //jLabelTopDescription.setText("Bievenido al sistema de gestión de mundiales de fútbol");

        jPanelMain.removeAll();
        JPanel homePanel = new JPanel();
        JLabel imageHome = new JLabel();

        imageHome.setIcon(new ImageIcon(getClass().getResource("/resources/fifacr7 (7).jpg"))); // NOI18N
        imageHome.setMaximumSize(jPanelMain.getPreferredSize());
        homePanel.add(imageHome);
        jPanelMain.add(homePanel, BorderLayout.CENTER);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación de SELECCIONES Define estilos, etiquetas, iconos
     * que decoran la opción del Menú. Esta opción de Menu permite mostrar las
     * selecciones de futbol cargadas en la aplicación
     */
    private void pintarMenuSelecciones() {
        btnSelecciones.setIcon(new ImageIcon(getClass().getResource("/resources/icons/selecciones.png"))); // NOI18N
        btnSelecciones.setText("Selecciones");
        btnSelecciones.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioSelecciones = new JLabel();
        jPanelMenuSelecciones.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuSelecciones.setPreferredSize((new java.awt.Dimension(220, 45)));
        jPanelMenuSelecciones.setLayout(new BorderLayout(15, 0));
        jPanelMenuSelecciones.add(vacioSelecciones, BorderLayout.WEST);
        jPanelMenuSelecciones.add(btnSelecciones, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuSelecciones);

        btnSelecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contador2++;
                accionSelecciones();
            }
        });
    }

    /**
     * Función que se ejecuta cuando el usuario hace click sobre la opción de
     * navegación Selecciones Permite ver la lista de selecciones que se
     * encuentran cargadas en la aplicación. Si la lista de selecciones en
     * vacía, muestra un botón que permite cargar un archivo CSV con la
     * información de las selelecciones
     */
    private void accionSelecciones() {
        jLabelTop.setText("selecciones");

        // Si no hay selecciones cargadas, muestra el botón de carga de selecciones
        if (selecciones == null) {
            jPanelMain.removeAll();
            JPanel seleccionesPanel = new JPanel();

            if (selecciones == null) {

                JLabel notSelecciones = new JLabel();
                notSelecciones.setText("No hay selecciones cargadas, por favor cargue selecciones \n\n");
                seleccionesPanel.add(notSelecciones);

                JButton cargarFile = new JButton();
                cargarFile.setText("Seleccione el archivo");
                seleccionesPanel.add(cargarFile);
                cargarFile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cargarFileSelecciones();
                    }
                });
            }

            jPanelMain.add(seleccionesPanel);
            jPanelMain.repaint();
            jPanelMain.revalidate();
        } // Si hay selecciones cargadas, llama el método que permite pintar la clasificadosUnSoloGrupo de selecciones
        else {
            pintarTablaSelecciones();
        }
    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación de RESULTADOS Define estilos, etiquetas, iconos
     * que decoran la opción del Menú. Esta opción de Menu permite mostrar los
     * diferentes resultados de los partidos de la fase de grupos de un mundial
     */
    private void pintarMenuResultados() {
        btnResultados.setIcon(new ImageIcon(getClass().getResource("/resources/icons/resultados.png"))); // NOI18N
        btnResultados.setText("Resultados");
        btnResultados.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioResultados = new JLabel();
        jPanelMenuResultados.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuResultados.setPreferredSize((new java.awt.Dimension(220, 45)));
        jPanelMenuResultados.setLayout(new BorderLayout(15, 0));
        jPanelMenuResultados.add(vacioResultados, BorderLayout.WEST);
        jPanelMenuResultados.add(btnResultados, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuResultados);

        btnResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionResultados();
            }
        });
    }

    /**
     * Función que se ejecuta cuando el usuario hace click sobre la opción de
     * navegación Resultados Permite ver la lista de resultados que se
     * encuentran cargadas en la aplicación. Si la lista de resultados en vacía,
     * muestra un botón que permite cargar un archivo CSV con la información de
     * los resultados
     */
    private void accionResultados() {
        if (contador3 == 10) {
            JOptionPane.showMessageDialog(null, "haz alcanzado el limite de visitas ");
        } else {
            contador3++;
        }
        jLabelTop.setText("Resultados");

        // Si no hay resultados cargados, muestra el botón de carga de resultados
        if (resultados == null) {
            jPanelMain.removeAll();
            JPanel resultadosPanel = new JPanel();

            if (resultados == null) {

                JLabel notResultados = new JLabel();
                notResultados.setText("No hay resultados, por favor cargue resultados \n\n");
                resultadosPanel.add(notResultados);

                JButton cargarFile = new JButton();
                cargarFile.setText("Seleccione el archivo");
                resultadosPanel.add(cargarFile);
                cargarFile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cargarFileResultados();
                    }
                });
            }

            jPanelMain.add(resultadosPanel);
            jPanelMain.repaint();
            jPanelMain.revalidate();
        } // Si hay ressultados cargados, llama el método que permite pintar la clasificadosUnSoloGrupo de resultados
        else {
            pintarTablaResultados();
        }
    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación de Dashboard de Selecciones Define estilos,
     * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
     * permite mostrar los diferentes datos que será extraidos de la información
     * de las selecciones de futbol que fueron cargadas
     */
    private void pintarMenuDashboardSel() {
        btnDashboardSel.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_selecciones.png")));
        btnDashboardSel.setText("Dash Selecciones");
        btnDashboardSel.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioDashboardSelecciones = new JLabel();
        jPanelMenuDashboardSel.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuDashboardSel.setPreferredSize((new java.awt.Dimension(220, 45)));
        jPanelMenuDashboardSel.setLayout(new BorderLayout(15, 0));
        jPanelMenuDashboardSel.add(vacioDashboardSelecciones, BorderLayout.WEST);
        jPanelMenuDashboardSel.add(btnDashboardSel, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuDashboardSel);

        btnDashboardSel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (contador4 == 10) {
                    JOptionPane.showMessageDialog(null, "haz alcanzado el limite de visitas ");
                } else {
                    contador4--;
                }

                accionDashboardSel();
            }
        });
    }

    /**
     * TRABAJO DEL ESTUDIANTE Se debe módificar este método para poder calcular
     * y pintar las diferentes informaciones que son solicitadas Revise el
     * proceso que se siguen en los demás métodos para poder actualizar la
     * información de los paneles
     */
    public void accionDashboardSel() {
        String[] columnNames = {"Continente", "Cantidad de paises por continente"};
        String[][] continentes = new String[7][2];
        continentes[0][0] = "América Central";
        continentes[1][0] = "Asia";
        continentes[2][0] = "África";
        continentes[3][0] = "América del Sur";
        continentes[4][0] = "América del Norte";
        continentes[5][0] = "Oceanía";
        continentes[6][0] = "Europa";
        int Contador = 0;

        for (int i = 0; i < selecciones.length; i++) {

            String continente = selecciones[i][2];//se crea una variable que va a guardar el nombre de cada continente 
            System.out.println("" + selecciones[i][2]);
            for (int j = 0; j < continentes.length; j++) {
                if (continentes[j][0].equals(continente)) {// presgunta si cada la matriz continentes es igual ala variable continente
                    if (continentes[j][1] == null) {
                        Contador = 0;
                    } else {
                        Contador = Integer.parseInt(continentes[j][1]);
                    }
                    continentes[j][1] = Integer.toString(Contador + 1);
                    break;
                }
            }
        }
        // Se ordena la matriz continentes com el que tenga mayor numero de paises
        // Este es el algoritmo de ordenamiento burbuja que ordena la matriz de continentes
        // en orden descendente según la cantidad de paises
        for (int i = 0; i < continentes.length - 1; i++) {
            for (int j = 0; j < continentes.length - i - 1; j++) {
                // Convertir la cantidad de población de cadena a entero
                int cantidad1 = Integer.parseInt(continentes[j][1]);
                int cantidad2 = Integer.parseInt(continentes[j + 1][1]);

                // Comprobar si los continentes deben intercambiarse
                if (cantidad1 < cantidad2) {
                    // se intercambian los continentes
                    String[] temp = continentes[j];
                    continentes[j] = continentes[j + 1];
                    continentes[j + 1] = temp;
                }
            }
        }

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(new Color(230, 230, 230));
        //desde aca
        JTextArea Cantidad_total_DT = new JTextArea();
        Cantidad_total_DT.setText("");
        String[] columnNames1 = {"Nacionalidad del DT", "Cant DT por pais "};
        String[][] nacionalidades = new String[25][2];
        String[] nacionalidadesDt = new String[25];  // arreglo para almacenar las nacionalidades
        int[] cantidadDt = new int[23];  // arreglo para almacenar la cantidad de DT por nacionalidad
        int Cantidad_total_DirectoresT = 0;

        //Se recorre la matriz selecciones y se cuentan las nacionalidades
        for (int i = 0; i < selecciones.length; i++) {
            String nacionalidad = selecciones[i][4];
            boolean encontrado = false;

            // Se Busca si la nacionalidad ya fue contabilizada previamente
            for (int j = 0; j < nacionalidadesDt.length; j++) {
                if (nacionalidadesDt[j] != null && nacionalidadesDt[j].equals(nacionalidad)) {
                    cantidadDt[j]++;
                    encontrado = true;
                    break;
                }
            }

            // Si la nacionalidad no fue contabilizada previamente, se agraga
            if (!encontrado) {
                for (int j = 0; j < nacionalidadesDt.length; j++) {
                    if (nacionalidadesDt[j] == null) {
                        nacionalidadesDt[j] = nacionalidad;
                        cantidadDt[j] = 1;
                        Cantidad_total_DirectoresT++;
                        break;
                    }
                }
            }
        }

        // Se Construye la matriz a partir de los arreglos de nacionalidades y cantidad de DT
        for (int i = 0; i < nacionalidadesDt.length; i++) {
            if (nacionalidadesDt[i] != null) {
                nacionalidades[i][0] = nacionalidadesDt[i];
                nacionalidades[i][1] = Integer.toString(cantidadDt[i]);

            }
        }
        String totalDTtexto = Integer.toString(Cantidad_total_DirectoresT);
        JLabel labelTotalDT = new JLabel("En Total hay " + totalDTtexto + " Tecnicos con Nacionalidades Distintas: ");
        JPanel panelcantidadDt = new JPanel();
        panelcantidadDt.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelcantidadDt.add(labelTotalDT);
        JTable tableContinentes = new JTable(continentes, columnNames);
        tableContinentes.setRowHeight(23);
        tableContinentes.setPreferredScrollableViewportSize(new Dimension(990, 200));

        JTable tableNacionalidades = new JTable(nacionalidades, columnNames1);
        tableNacionalidades.setRowHeight(23);
        tableNacionalidades.setPreferredScrollableViewportSize(new Dimension(990, 550));

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.add(new JScrollPane(tableContinentes), BorderLayout.NORTH);
        panelTabla.add(new JScrollPane(tableNacionalidades), BorderLayout.SOUTH);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelcantidadDt, BorderLayout.NORTH);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);

        jPanelMain.removeAll();
        jPanelMain.add(panelPrincipal);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación de Dashboard de Resultados Define estilos,
     * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
     * permite mostrar los diferentes datos que será extraidos de la información
     * de los resultados de los partidos que fueron cargados
     */
    private void pintarMenuDashboardRes() {
        btnDashboardRes.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_resultados.png")));
        btnDashboardRes.setText("Dash Resultados");
        btnDashboardRes.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioDashboardResultados = new JLabel();
        jPanelMenuDashboardRes.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuDashboardRes.setPreferredSize((new java.awt.Dimension(220, 45)));
        jPanelMenuDashboardRes.setLayout(new BorderLayout(15, 0));
        jPanelMenuDashboardRes.add(vacioDashboardResultados, BorderLayout.WEST);
        jPanelMenuDashboardRes.add(btnDashboardRes, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuDashboardRes);

        btnDashboardRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (contador5 == 10) {
                    JOptionPane.showMessageDialog(null, "haz alcanzado el limite de visitas ");
                } else {
                    contador5++;
                }
                accionDashboardRes();
                //clasificadosMundial();
                //partidos();
            }
        });
    }

    private void botonmatrizx() {
        botonmatrizx.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_resultados.png")));
        botonmatrizx.setText("Boton de pruebas");
        botonmatrizx.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioDashboardResultados = new JLabel();
        japanelmatrix.setBackground(new java.awt.Color(17, 41, 63));
        japanelmatrix.setPreferredSize((new java.awt.Dimension(220, 35)));
        japanelmatrix.setLayout(new BorderLayout(15, 0));
        japanelmatrix.add(vacioDashboardResultados, BorderLayout.WEST);
        japanelmatrix.add(botonmatrizx, BorderLayout.CENTER);
        jPanelMenu.add(japanelmatrix);

        botonmatrizx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partidos();
                //accionDashboardRes();
                // partidosResultados();
            }
        });
    }

    private void accionMatrizAleatoria() {
        String[] columnNames = {"Sitio", " Cantidad visitas"};
        Matriz[0][0] = "Home";
        Matriz[1][0] = "Selecciones";
        Matriz[2][0] = "Resultados";
        Matriz[3][0] = "Dash Selecciones";
        Matriz[4][0] = "Dash Resultados";
        Matriz[0][1] = Integer.toString(contador1);
        Matriz[1][1] = Integer.toString(contador2);
        Matriz[2][1] = Integer.toString(contador3);
        Matriz[3][1] = Integer.toString(contador4);
        Matriz[4][1] = Integer.toString(contador5);

        //aca
        //
        JTable tablenacionalidades = new JTable(Matriz, columnNames);
        tablenacionalidades.setRowHeight(20);//altuta de la fila
        JScrollPane scrollPane = new JScrollPane(tablenacionalidades);

        jPanelMain.removeAll();
        jPanelMain.add(scrollPane);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    private void partidosResultados() {

    }

    private void partidos() {
        String[] column1 = {"Selecciones", "Menos Goles"};
        String[] column2 = {"Selecciones", "Mas Goles"};
        // Variables para almacenar los goles de cada equipo
        String[][] equiposGoles = new String[resultados.length][2]; // [0]: Equipo, [1]: Goles
        int contadorEquipos = 0;

        // Sumar goles para cada equipo
        for (String[] resultado : resultados) {
            String equipoLocal = resultado[1];
            String equipoVisitante = resultado[2];
            int golesLocal = Integer.parseInt(resultado[5]);
            int golesVisitante = Integer.parseInt(resultado[6]);

            // Sumar goles al equipo local
            boolean encontradoLocal = false;
            for (int i = 0; i < contadorEquipos; i++) {
                if (equiposGoles[i][0].equals(equipoLocal)) {
                    equiposGoles[i][1] = Integer.toString(Integer.parseInt(equiposGoles[i][1]) + golesLocal);
                    encontradoLocal = true;
                    break;
                }
            }
            if (!encontradoLocal) {
                equiposGoles[contadorEquipos][0] = equipoLocal;
                equiposGoles[contadorEquipos][1] = Integer.toString(golesLocal);
                contadorEquipos++;
            }

            // Sumar goles al equipo visitante
            boolean encontradoVisitante = false;
            for (int i = 0; i < contadorEquipos; i++) {
                if (equiposGoles[i][0].equals(equipoVisitante)) {
                    equiposGoles[i][1] = Integer.toString(Integer.parseInt(equiposGoles[i][1]) + golesVisitante);
                    encontradoVisitante = true;
                    break;
                }
            }
            if (!encontradoVisitante) {
                equiposGoles[contadorEquipos][0] = equipoVisitante;
                equiposGoles[contadorEquipos][1] = Integer.toString(golesVisitante);
                contadorEquipos++;
            }
        }

        // Ordenar equipos por cantidad de goles (en orden descendente)
        for (int i = 0; i < contadorEquipos - 1; i++) {
            for (int j = i + 1; j < contadorEquipos; j++) {
                int golesEquipoI = Integer.parseInt(equiposGoles[i][1]);
                int golesEquipoJ = Integer.parseInt(equiposGoles[j][1]);

                if (golesEquipoI < golesEquipoJ) {
                    // Intercambiar equipos
                    String[] temp = equiposGoles[i];
                    equiposGoles[i] = equiposGoles[j];
                    equiposGoles[j] = temp;
                }
            }
        }

        // Llenar la matriz masGoles con los cinco equipos que marcaron más goles
        String[][] masGoles = new String[5][2];
        for (int i = 0; i < 5 && i < contadorEquipos; i++) {
            masGoles[i][0] = equiposGoles[i][0];
            masGoles[i][1] = equiposGoles[i][1];
        }

        // Llenar la matriz menosGoles con los siete equipos que marcaron menos goles
        String[][] menosGoles = new String[7][2];
        for (int i = contadorEquipos - 1, j = 0; i >= contadorEquipos - 7 && i >= 0; i--, j++) {
            menosGoles[j][0] = equiposGoles[i][0];
            menosGoles[j][1] = equiposGoles[i][1];
        }
        //
        String[][] partidoMasGoles = new String[2][6];
        String[][] partidoMenosGoles = new String[2][6];

        // Variables para almacenar la cantidad máxima y mínima de goles
        int maxGoles = Integer.MIN_VALUE;
        int minGoles = Integer.MAX_VALUE;

        // Iteración sobre la matriz resultados para encontrar el partido con más goles y menos goles
        for (int i = 0; i < resultados.length; i++) {
            String grupo = resultados[i][0];
            String equipoLocal = resultados[i][1];
            String equipoVisitante = resultados[i][2];
            int golesLocal = Integer.parseInt(resultados[i][5]);
            int golesVisitante = Integer.parseInt(resultados[i][6]);
            int totalGoles = golesLocal + golesVisitante;

            // Actualizar el partido con más goles
            if (totalGoles > maxGoles) {
                maxGoles = totalGoles;
                partidoMasGoles[0][0] = grupo;
                partidoMasGoles[0][1] = equipoLocal;
                partidoMasGoles[0][2] = equipoVisitante;
                partidoMasGoles[0][3] = Integer.toString(golesLocal);
                partidoMasGoles[0][4] = Integer.toString(golesVisitante);
                partidoMasGoles[0][5] = Integer.toString(totalGoles);
            }

            // Actualizar el partido con menos goles
            if (totalGoles < minGoles) {
                minGoles = totalGoles;
                partidoMenosGoles[0][0] = grupo;
                partidoMenosGoles[0][1] = equipoLocal;
                partidoMenosGoles[0][2] = equipoVisitante;
                partidoMenosGoles[0][3] = Integer.toString(golesLocal);
                partidoMenosGoles[0][4] = Integer.toString(golesVisitante);
                partidoMenosGoles[0][5] = Integer.toString(totalGoles);
            }
        }

        String[] columnaMenosGoles = {"Grupo: ", "Equipo Local: ", "Equipo Visitante: ", "Goles Local: ", "Goles Visitante: ", "Total Goles: "};
        String[] columnaMasGoles = {"Grupo: ", "Equipo Local: ", "Equipo Visitante: ", "Goles Local: ", "Goles Visitante: ", "Total Goles: "};
        JTable patidoMenosGoles = new JTable(partidoMenosGoles, columnaMenosGoles);
        JTable patidoMasGoles = new JTable(partidoMasGoles, columnaMasGoles);

        JLabel LabelmenosGoles = new JLabel("El partido con menos Goles");
        JLabel LabelmasGoles = new JLabel("El partido con más Goles ");

        JTable MenosGoles = new JTable(menosGoles, column1);
        JTable MasGoles = new JTable(masGoles, column2);

        MasGoles.setPreferredScrollableViewportSize(new Dimension(980, 60));//ancho y alto de la tabla
        MenosGoles.setPreferredScrollableViewportSize(new Dimension(980, 60));//ancho y alto de la tabla
        patidoMenosGoles.setPreferredScrollableViewportSize(new Dimension(980, 70));
        patidoMasGoles.setPreferredScrollableViewportSize(new Dimension(980, 90));
        JPanel panelTabla1 = new JPanel(new BorderLayout());
        JPanel panelTabla2 = new JPanel(new BorderLayout());
        JPanel panelTabla3 = new JPanel(new BorderLayout());

        panelTabla2.add(new JScrollPane(LabelmasGoles), BorderLayout.NORTH);
        panelTabla2.add(new JScrollPane(patidoMasGoles), BorderLayout.CENTER);

        panelTabla3.add(new JScrollPane(LabelmenosGoles), BorderLayout.NORTH);
        panelTabla3.add(new JScrollPane(patidoMenosGoles), BorderLayout.CENTER);

        panelTabla1.add(new JScrollPane(MasGoles), BorderLayout.NORTH);
        panelTabla1.add(new JScrollPane(MenosGoles), BorderLayout.CENTER);
        panelTabla1.setPreferredSize(new Dimension(1000, 450));
        panelTabla2.setPreferredSize(new Dimension(1000, 70));
        panelTabla3.setPreferredSize(new Dimension(1000, 70));
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelTabla2, BorderLayout.NORTH);
        panelPrincipal.add(panelTabla3, BorderLayout.CENTER);
        panelPrincipal.add(panelTabla1, BorderLayout.SOUTH);

        panelPrincipal.setPreferredSize(new Dimension(1000, 800));
//
        jPanelMain.removeAll();
        jPanelMain.add(panelPrincipal);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * TRABAJO DEL ESTUDIANTE Se debe módificar este método para poder calcular
     * y pintar las diferentes informaciones que son solicitadas Revise el
     * proceso que se siguen en los demás métodos para poder actualizar la
     * información de los paneles
     */
    private void accionDashboardRes() {

        JTextArea a = new JTextArea();
        a.setText("En esta sección, teniendo en cuenta los datos que fueron cargados en la matriz de resultados \n"
                + "se deben mostrar los siguientes datos:\n\n"
                + "1. Número de partidos cargados \n"
                + "2. Promedio de goles por partido \n"
                + "3. Partido con más goles y partido con menos goles \n"
                + "4. Número de partidos dónde hubo un ganador y número de partidos dónde hubo empate \n"
                + "5. Selección o selecciones con más goles y con menos goles \n"
                + "6. Selección con más puntos y menos puntos \n"
                + "7. Continente o continentes con más goles y menos goles \n"
                + "8. Clasificados por cada grupo (Clasifican los dos primeros equipos de cada grupo) \n\n"
                + "Utilice los diferentes componentes gráficos para construir un dashboard lo más estético posible ");
        String[][] matriz_Grupo_A = new String[6][7];
        String[][] matriz_Grupo_B = new String[6][7];
        String[][] matriz_Grupo_C = new String[6][7];
        String[][] matriz_Grupo_D = new String[6][7];
        String[][] matriz_Grupo_E = new String[6][7];
        String[][] matriz_Grupo_F = new String[6][7];
        String[][] matriz_Grupo_G = new String[6][7];
        String[][] matriz_Grupo_H = new String[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matriz_Grupo_A[i][j] = resultados[i][j];
                matriz_Grupo_B[i][j] = resultados[i + 6][j];
                matriz_Grupo_C[i][j] = resultados[i + 12][j];
                matriz_Grupo_D[i][j] = resultados[i + 18][j];
                matriz_Grupo_E[i][j] = resultados[i + 24][j];
                matriz_Grupo_F[i][j] = resultados[i + 30][j];
                matriz_Grupo_G[i][j] = resultados[i + 36][j];
                matriz_Grupo_H[i][j] = resultados[i + 42][j];
            }
        }

        String[][] clasificados = new String[16][5]; // Matriz para almacenar los 16 clasificados a su grupo correspondiente, los puntos obtenidos, los goles a favor y los goles en contra
        int contadorClasificados = 0;

        // Se itera sobre cada grupo y se calculan los puntajes, goles a favor y goles en contra
        for (int grupo = 0; grupo < 8; grupo++) {
            String[][] matrizGrupo = null;

            // Asignar la matriz correspondiente según el grupo
            switch (grupo) {
                case 0:
                    matrizGrupo = matriz_Grupo_A;
                    break;
                case 1:
                    matrizGrupo = matriz_Grupo_B;
                    break;
                case 2:
                    matrizGrupo = matriz_Grupo_C;
                    break;
                case 3:
                    matrizGrupo = matriz_Grupo_D;
                    break;
                case 4:
                    matrizGrupo = matriz_Grupo_E;
                    break;
                case 5:
                    matrizGrupo = matriz_Grupo_F;
                    break;
                case 6:
                    matrizGrupo = matriz_Grupo_G;
                    break;
                case 7:
                    matrizGrupo = matriz_Grupo_H;
                    break;
            }

            // Se calculan los puntajes, goles a favor y goles en contra del grupo actual
            int[][] puntajesGolesGrupo = new int[6][4]; // Columna 1: puntajes, Columna 2: goles a favor, Columna 3: goles en contra, Columna 4: diferencia de goles
            for (int i = 0; i < matrizGrupo.length; i++) {
                //Se obtienen los goles local y visitante
                int golesLocal = Integer.parseInt(matrizGrupo[i][5]);
                int golesVisitante = Integer.parseInt(matrizGrupo[i][6]);

                // Se Obtinen los índices de los equipos local y visitante en el grupo
                int equipoLocal = 0;
                int equipoVisitante = 0;
                for (int j = 0; j < matrizGrupo.length; j++) {
                    if (matrizGrupo[j][1].equals(matrizGrupo[i][1])) {
                        equipoLocal = j;
                        break;
                    }
                }
                for (int j = 0; j < matrizGrupo.length; j++) {
                    if (matrizGrupo[j][1].equals(matrizGrupo[i][2])) {
                        equipoVisitante = j;
                        break;
                    }
                }

                // Se actualizan los puntajes, goles a favor y goles en contra según el resultado del partido
                if (golesLocal > golesVisitante) {
                    puntajesGolesGrupo[equipoLocal][0] += 3;
                } else if (golesLocal < golesVisitante) {
                    puntajesGolesGrupo[equipoVisitante][0] += 3;
                } else {
                    puntajesGolesGrupo[equipoLocal][0] += 1;
                    puntajesGolesGrupo[equipoVisitante][0] += 1;
                }

                puntajesGolesGrupo[equipoLocal][1] += golesLocal;
                puntajesGolesGrupo[equipoLocal][2] += golesVisitante;
                puntajesGolesGrupo[equipoVisitante][1] += golesVisitante;
                puntajesGolesGrupo[equipoVisitante][2] += golesLocal;
            }

            //Para encontrar los dos equipos con mayor puntaje en el grupo
            int puntajeMaximo1 = 0;
            int puntajeMaximo2 = 0;
            int equpoPuntajeMaximo1 = 0;
            int equpoPuntajeMaximo2 = 0;
            for (int i = 0; i < puntajesGolesGrupo.length; i++) {
                if (puntajesGolesGrupo[i][0] > puntajeMaximo1) {
                    puntajeMaximo2 = puntajeMaximo1;
                    equpoPuntajeMaximo2 = equpoPuntajeMaximo1;
                    puntajeMaximo1 = puntajesGolesGrupo[i][0];
                    equpoPuntajeMaximo1 = i;
                } else if (puntajesGolesGrupo[i][0] > puntajeMaximo2) {
                    puntajeMaximo2 = puntajesGolesGrupo[i][0];
                    equpoPuntajeMaximo2 = i;
                }
            }

            // Se agregan los equipos clasificados, su grupo correspondiente, los puntos obtenidos, los goles a favor y los goles en contra a la matriz
            clasificados[contadorClasificados][1] = matrizGrupo[equpoPuntajeMaximo1][1]; // Equipo clasificado
            clasificados[contadorClasificados][0] = "Grupo " + (char) ('A' + grupo); // Grupo correspondiente
            clasificados[contadorClasificados][2] = String.valueOf(puntajeMaximo1); // Puntos obtenidos
            clasificados[contadorClasificados][3] = String.valueOf(puntajesGolesGrupo[equpoPuntajeMaximo1][1]); // Goles a favor
            clasificados[contadorClasificados][4] = String.valueOf(puntajesGolesGrupo[equpoPuntajeMaximo1][2]); // Goles en contra
            contadorClasificados++;

            clasificados[contadorClasificados][1] = matrizGrupo[equpoPuntajeMaximo2][1]; // Equipo clasificado
            clasificados[contadorClasificados][0] = "Grupo " + (char) ('A' + grupo); // Grupo correspondiente
            clasificados[contadorClasificados][2] = String.valueOf(puntajeMaximo2); // Puntos obtenidos
            clasificados[contadorClasificados][3] = String.valueOf(puntajesGolesGrupo[equpoPuntajeMaximo2][1]); // Goles a favor
            clasificados[contadorClasificados][4] = String.valueOf(puntajesGolesGrupo[equpoPuntajeMaximo2][2]); // Goles en contra
            contadorClasificados++;
        }
        //Desde 
        String[] continentes = {"Europa", "Asia", "África", "América del Sur", "América Central", "América del Norte"};
        int[] golesPorContinente = new int[continentes.length];

        // Recorrer la matriz "resultados" y sumar los goles por continente
        for (int i = 0; i < resultados.length; i++) {
            String continenteLocal = resultados[i][3];
            String continenteVisitante = resultados[i][4];
            int golesLocal = Integer.parseInt(resultados[i][5]);
            int golesVisitante = Integer.parseInt(resultados[i][6]);
            // Buscar el índice del continente local en el arreglo
            int ubicaciondelequipoLocal = -1;
            for (int j = 0; j < continentes.length; j++) {
                if (continentes[j].equals(continenteLocal)) {
                    ubicaciondelequipoLocal = j;
                    break;
                }
            }
            // Se busca el índice del continente visitante en el arreglo
            int ubicaciondelequipoVisitante = -1;
            for (int j = 0; j < continentes.length; j++) {
                if (continentes[j].equals(continenteVisitante)) {
                    ubicaciondelequipoVisitante = j;
                    break;
                }
            }
            // Se suman los goles del equipo local al continente correspondiente
            if (ubicaciondelequipoLocal != -1) {
                golesPorContinente[ubicaciondelequipoLocal] += golesLocal;
            }
            // Se suman  los goles del equipo visitante al continente correspondiente
            if (ubicaciondelequipoVisitante != -1) {
                golesPorContinente[ubicaciondelequipoVisitante] += golesVisitante;
            }
        }
        // Se crea una matriz para almacenar los nombres de los continentes y los goles obtenidos
        String[][] matrizGolesPorContinente = new String[continentes.length][2];
        // Llenar la matriz con los nombres de los continentes y los goles obtenidos
        for (int i = 0; i < continentes.length; i++) {
            matrizGolesPorContinente[i][0] = continentes[i];
            matrizGolesPorContinente[i][1] = String.valueOf(golesPorContinente[i]);
        }
        // Se ordena la matriz en orden descendente según la cantidad de goles obtenidos
        for (int i = 0; i < continentes.length - 1; i++) {
            for (int j = 0; j < continentes.length - i - 1; j++) {
                int goles1 = Integer.parseInt(matrizGolesPorContinente[j][1]);
                int goles2 = Integer.parseInt(matrizGolesPorContinente[j + 1][1]);
                if (goles1 < goles2) {
                    // Intercambiar las filas
                    String[] temp = matrizGolesPorContinente[j];
                    matrizGolesPorContinente[j] = matrizGolesPorContinente[j + 1];
                    matrizGolesPorContinente[j + 1] = temp;
                }
            }
        }
        int partidosGanados = 0;
        int partidosEmpate = 0;

        for (int i = 0; i < resultados.length; i++) {
            int golesLocal = Integer.parseInt(resultados[i][5]);
            int golesVisitante = Integer.parseInt(resultados[i][6]);

            if (golesLocal > golesVisitante || golesLocal < golesVisitante) {
                partidosGanados++;
            } else {
                partidosEmpate++;
            }
        }

        int partidosCargados = resultados.length;
        int sumaGolesL = 0;
        int sumaGolesV = 0;
        for (int i = 0; i < resultados.length; i++) {
            sumaGolesL += Integer.parseInt(resultados[i][5]); //Se suman los elementos en la columna 5 (Goles L)
            System.out.println("local: " + sumaGolesL);
            sumaGolesV += Integer.parseInt(resultados[i][6]); //Se suman los elementos en la columna 6 (Goles V)
            System.out.println("visitante: " + sumaGolesV);
        }
        //desde aca
        String[] column1 = {"Selecciones", "Menos Goles"};
        String[] column2 = {"Selecciones", "Mas Goles"};
        // Variables para almacenar los goles de cada equipo
        String[][] equiposGoles = new String[resultados.length][2]; // [0]: Equipo, [1]: Goles
        int contadorEquipos = 0;

        // Sumar goles para cada equipo
        for (String[] resultado : resultados) {
            String equipoLocal = resultado[1];
            String equipoVisitante = resultado[2];
            int golesLocal = Integer.parseInt(resultado[5]);
            int golesVisitante = Integer.parseInt(resultado[6]);

            // Sumar goles al equipo local
            boolean encontradoLocal = false;
            for (int i = 0; i < contadorEquipos; i++) {
                if (equiposGoles[i][0].equals(equipoLocal)) {
                    equiposGoles[i][1] = Integer.toString(Integer.parseInt(equiposGoles[i][1]) + golesLocal);
                    encontradoLocal = true;
                    break;
                }
            }
            if (!encontradoLocal) {
                equiposGoles[contadorEquipos][0] = equipoLocal;
                equiposGoles[contadorEquipos][1] = Integer.toString(golesLocal);
                contadorEquipos++;
            }

            // Sumar goles al equipo visitante
            boolean encontradoVisitante = false;
            for (int i = 0; i < contadorEquipos; i++) {
                if (equiposGoles[i][0].equals(equipoVisitante)) {
                    equiposGoles[i][1] = Integer.toString(Integer.parseInt(equiposGoles[i][1]) + golesVisitante);
                    encontradoVisitante = true;
                    break;
                }
            }
            if (!encontradoVisitante) {
                equiposGoles[contadorEquipos][0] = equipoVisitante;
                equiposGoles[contadorEquipos][1] = Integer.toString(golesVisitante);
                contadorEquipos++;
            }
        }

        // Ordenar equipos por cantidad de goles (en orden descendente)
        for (int i = 0; i < contadorEquipos - 1; i++) {
            for (int j = i + 1; j < contadorEquipos; j++) {
                int golesEquipoI = Integer.parseInt(equiposGoles[i][1]);
                int golesEquipoJ = Integer.parseInt(equiposGoles[j][1]);

                if (golesEquipoI < golesEquipoJ) {
                    // Intercambiar equipos
                    String[] temp = equiposGoles[i];
                    equiposGoles[i] = equiposGoles[j];
                    equiposGoles[j] = temp;
                }
            }
        }

        // Llenar la matriz masGoles con los cinco equipos que marcaron más goles
        String[][] masGoles = new String[5][2];
        for (int i = 0; i < 5 && i < contadorEquipos; i++) {
            masGoles[i][0] = equiposGoles[i][0];
            masGoles[i][1] = equiposGoles[i][1];
        }

        // Llenar la matriz menosGoles con los siete equipos que marcaron menos goles
        String[][] menosGoles = new String[7][2];
        for (int i = contadorEquipos - 1, j = 0; i >= contadorEquipos - 7 && i >= 0; i--, j++) {
            menosGoles[j][0] = equiposGoles[i][0];
            menosGoles[j][1] = equiposGoles[i][1];
        }
        //
        String[][] partidoMasGoles = new String[2][6];
        String[][] partidoMenosGoles = new String[2][6];

        // Variables para almacenar la cantidad máxima y mínima de goles
        int maxGoles = Integer.MIN_VALUE;
        int minGoles = Integer.MAX_VALUE;

        // Iteración sobre la matriz resultados para encontrar el partido con más goles y menos goles
        for (int i = 0; i < resultados.length; i++) {
            String grupo = resultados[i][0];
            String equipoLocal = resultados[i][1];
            String equipoVisitante = resultados[i][2];
            int golesLocal = Integer.parseInt(resultados[i][5]);
            int golesVisitante = Integer.parseInt(resultados[i][6]);
            int totalGoles = golesLocal + golesVisitante;

            // Actualizar el partido con más goles
            if (totalGoles > maxGoles) {
                maxGoles = totalGoles;
                partidoMasGoles[0][0] = grupo;
                partidoMasGoles[0][1] = equipoLocal;
                partidoMasGoles[0][2] = equipoVisitante;
                partidoMasGoles[0][3] = Integer.toString(golesLocal);
                partidoMasGoles[0][4] = Integer.toString(golesVisitante);
                partidoMasGoles[0][5] = Integer.toString(totalGoles);
            }

            // Actualizar el partido con menos goles
            if (totalGoles < minGoles) {
                minGoles = totalGoles;
                partidoMenosGoles[0][0] = grupo;
                partidoMenosGoles[0][1] = equipoLocal;
                partidoMenosGoles[0][2] = equipoVisitante;
                partidoMenosGoles[0][3] = Integer.toString(golesLocal);
                partidoMenosGoles[0][4] = Integer.toString(golesVisitante);
                partidoMenosGoles[0][5] = Integer.toString(totalGoles);
            }
        }

        String[] columnaMenosGoles = {"Grupo: ", "Equipo Local: ", "Equipo Visitante: ", "Goles Local: ", "Goles Visitante: ", "Total Goles: "};
        String[] columnaMasGoles = {"Grupo: ", "Equipo Local: ", "Equipo Visitante: ", "Goles Local: ", "Goles Visitante: ", "Total Goles: "};
        JTable patidoMenosGoles = new JTable(partidoMenosGoles, columnaMenosGoles);
        JTable patidoMasGoles = new JTable(partidoMasGoles, columnaMasGoles);
        patidoMasGoles.setPreferredScrollableViewportSize(new Dimension(980, 20));
        patidoMenosGoles.setPreferredScrollableViewportSize(new Dimension(980, 20));
        JLabel LabelmenosGoles = new JLabel("Partido con menos Goles");
        JLabel LabelmasGoles = new JLabel("Partido con más Goles ");
        JTable MenosGoles = new JTable(menosGoles, column1);
        JTable MasGoles = new JTable(masGoles, column2);
        MasGoles.setPreferredScrollableViewportSize(new Dimension(980, 85));
        MenosGoles.setPreferredScrollableViewportSize(new Dimension(980, 95));

        JPanel panelTabla1 = new JPanel(new BorderLayout());
        JPanel panelTabla2 = new JPanel(new BorderLayout());
        JPanel panelTabla3 = new JPanel(new BorderLayout());
        JPanel panelTabla4 = new JPanel(new BorderLayout());

        panelTabla1.add(new JScrollPane(LabelmasGoles), BorderLayout.NORTH);
        panelTabla1.add(new JScrollPane(patidoMasGoles), BorderLayout.CENTER);
        // panelTabla1.setPreferredSize(new Dimension(1000, 60));

        panelTabla2.add(new JScrollPane(LabelmenosGoles), BorderLayout.NORTH);
        panelTabla2.add(new JScrollPane(patidoMenosGoles), BorderLayout.CENTER);
        //panelTabla2.setPreferredSize(new Dimension(1000, 50));

        panelTabla3.add(new JScrollPane(MasGoles), BorderLayout.NORTH);
        panelTabla3.add(new JScrollPane(MenosGoles), BorderLayout.CENTER);

        panelTabla4.add(panelTabla1, BorderLayout.NORTH);
        panelTabla4.add(panelTabla2, BorderLayout.CENTER);
        panelTabla4.add(panelTabla3, BorderLayout.SOUTH);
        panelTabla4.setPreferredSize(new Dimension(1000, 350));

        //
        JPanel panelGanador = new JPanel(new BorderLayout());
        JPanel panelContenedor = new JPanel(new BorderLayout());
        JPanel panelPartidos = new JPanel(new BorderLayout());
        JLabel labelPartidosGanador = new JLabel("Número de partidos donde hubo ganador: " + partidosGanados);
        JLabel labelPartidosEmpate = new JLabel("Número de partidos donde hubo empate: " + partidosEmpate);
        JLabel contienteMasGoles = new JLabel("El Continente con Mas goles es: "
                + matrizGolesPorContinente[0][0] + " Con: " + matrizGolesPorContinente[0][1] + " Goles");
        JLabel contienteMenosGoles = new JLabel("El Continente con Menos Goles es: "
                + matrizGolesPorContinente[5][0] + " Con: " + matrizGolesPorContinente[5][1] + " Goles");

        panelPartidos.add(new JScrollPane(labelPartidosGanador), BorderLayout.NORTH);
        panelPartidos.add(new JScrollPane(labelPartidosEmpate), BorderLayout.SOUTH);
        panelGanador.add(new JScrollPane(contienteMasGoles), BorderLayout.NORTH);
        panelGanador.add(new JScrollPane(contienteMenosGoles), BorderLayout.SOUTH);
        double promedioGoles = (double) (sumaGolesL + sumaGolesV) / 48; // calcular el promedio de la suma de Goles L
        //En este caso, %.2f indica que se deben mostrar dos decimales después del punto decimal para un valor de tipo double
        String PromedioGoles = String.format("%.2f", promedioGoles);
        JLabel labelpromedioGoles = new JLabel("El promedio de goles por partido es: " + PromedioGoles);

        JLabel labelTotalpartidos = new JLabel("Total Partidos cargados: " + partidosCargados);
        labelTotalpartidos.setPreferredSize(new Dimension(400, 70));
        String[] columnNames = {"Grupo", "Equipo clasificado", "Puntos", "Goles a favor", "Goles en contra"};
        JTable tableClasificados = new JTable(clasificados, columnNames);
        tableClasificados.setRowHeight(20);//altuta de la fila
        tableClasificados.setPreferredScrollableViewportSize(new Dimension(980, 200));//ancho y alto de la tabla

        JPanel panelGoles = new JPanel(new BorderLayout());
        panelGoles.add(new JScrollPane(labelpromedioGoles), BorderLayout.CENTER);
        panelGoles.add(new JScrollPane(labelTotalpartidos), BorderLayout.SOUTH);

        panelGoles.add(new JScrollPane(tableClasificados), BorderLayout.NORTH);

        panelContenedor.add(new JScrollPane(panelPartidos), BorderLayout.CENTER);
        panelContenedor.add(new JScrollPane(panelGanador), BorderLayout.SOUTH);
        panelContenedor.add(new JScrollPane(panelGoles), BorderLayout.NORTH);
        panelContenedor.setPreferredSize(new Dimension(1000, 350));
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        panelPrincipal.add(panelTabla4, BorderLayout.NORTH);
        panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
        panelPrincipal.setPreferredSize(new Dimension(1000, 745));

        jPanelMain.removeAll();
        jPanelMain.add(panelPrincipal);
        jPanelMain.repaint();
        jPanelMain.revalidate();

    }

    /**
     * Función que permite darle estilos y agregar los componentes gráficos del
     * contendor de la parte izquierda de la interfaz, dónde se visulaiza el
     * menú de navegaación
     */
    private void pintarPanelIzquierdo() {
        // Se elimina el color de fondo del panel del menú
        jPanelMenu.setOpaque(false);

        // Se agrega un border izquierdo, de color blanco para diferenciar el panel de menú del panel de contenido
        jPanelLeft.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.WHITE));

        // Se define un BoxLayot de manera vertical para los elementos del panel izquierdo
        jPanelLeft.setLayout(new BoxLayout(jPanelLeft, BoxLayout.Y_AXIS));
        jPanelLeft.setBackground(new java.awt.Color(0, 24, 47));
        getContentPane().add(jPanelLeft, java.awt.BorderLayout.LINE_START);
        jPanelLeft.add(jPanelMenu);
        jPanelLeft.setPreferredSize((new java.awt.Dimension(220, 540)));
        jPanelLeft.setMaximumSize(jPanelLeft.getPreferredSize());
    }

    /**
     * Función que permite leer un archivo y procesar el contenido que tiene en
     * cada una de sus líneas El contenido del archivo es procesado y cargado en
     * la matriz de selecciones. Una vez la información se carga en la atriz, se
     * hace un llamado a la función pintarTablaSelecciones() que se encarga de
     * pintar en la interfaz una tabla con la información almacenada en la
     * matriz de selecciones
     */
    public void cargarFileSelecciones() {

        JFileChooser cargarFile = new JFileChooser();
        cargarFile.showOpenDialog(cargarFile);

        Scanner entrada = null;
        try {

            // Se obtiene la ruta del archivo seleccionado
            String ruta = cargarFile.getSelectedFile().getAbsolutePath();

            // Se obtiene el archivo y se almancena en la variable f
            File f = new File(ruta);
            entrada = new Scanner(f);

            // Se define las dimensiones de la matriz de selecciones
            selecciones = new String[32][5];

            // Permite que el sistema se salte la léctura de los encabzados del archivo CSV
            entrada.nextLine();

            int i = 0;
            // Se leen cada unas de las líneas del archivo
            while (entrada.hasNext()) {
                System.out.println(i);
                String line = entrada.nextLine();
                String[] columns = line.split(",");

                for (int j = 0; j < columns.length; j++) {
                    selecciones[i][j] = columns[j];
                }
                i++;
            }

            pintarTablaSelecciones();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    /**
     * Función que se encarga de pinta la clasificadosUnSoloGrupo con la
     * información de las selelceciones que fue cargada previamente La
     * clasificadosUnSoloGrupo tiene definido un encabezado con las siguentes
     * columnas: {"ID","Selección", "Continente", "DT", "Nacionalidad DT"}
     * Columnas que se corresponden son la información que fue leida desde el
     * archivo csv
     */
    public void pintarTablaSelecciones() {

        pintarDetalleTablas(selecciones);
    }

    public void filtrarSelecciones(String cadena) {

        seleccionesFiltro = new String[32][5];

        int j = 0;

        for (int i = 0; i < selecciones.length; i++) {
            String[] seleccion = selecciones[i];
            if (seleccion[1].contains(cadena) || seleccion[2].contains(cadena)) {
                seleccionesFiltro[j] = seleccion;
                j++;
            }
        }

        String[][] seleccionesFinal = Arrays.copyOfRange(seleccionesFiltro, 0, j);

        pintarDetalleTablas(seleccionesFinal);

    }

    public void pintarTablaResultados() {

        pintarDetalleResultados(resultados);
    }

    public void filtrarResultados(String cadena) {

        resultadosFiltro = new String[48][7];

        int j = 0;
        for (int i = 0; i < resultados.length; i++) {
            // Obtiene una fila de la matriz "resultados" y la almacena en una nueva matriz llamada "resultado".
            String[] resultado = resultados[i];
            boolean encontrado = false;

            // Recorre todos los elementos de la fila actual.
            for (int k = 0; k < resultado.length; k++) {

                // Si se encuentra la cadena de búsqueda en algún elemento de la fila, la variable 
                //"encontrado" cambia a "true" y detiene el bucle "for" interno.
                if (resultado[k].contains(cadena)) {
                    encontrado = true;
                    break;
                }
            }
            // Si se encontró la cadena de búsqueda en algún lugar de la fila actual,
            //copia la fila actual en la matriz "resultadosFiltro" en la posición "j" y aumenta la variable "j" en 1.
            if (encontrado) {
                resultadosFiltro[j] = resultado;
                j++;
            }
        }

        // Se crea una nueva matriz que contiene solo los resultados que cumplen con el criterio de búsqueda.
        String[][] resultadosFinal = Arrays.copyOfRange(resultadosFiltro, 0, j);

        // Se llama el otro método para mostrar los resultados filtrados 
        pintarDetalleResultados(resultadosFinal);
    }

    private void pintarDetalleTablas(String[][] selecciones1) {
        String[] columnNames = {"ID", "Selección", "Continente", "DT", "Nacionalidad DT"};

        JTable table = new JTable(selecciones1, columnNames);
        table.setRowHeight(30);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(4, 1, 0, 0));

        JLabel label = new JLabel();
        label.setText("Busqueda de Equipos");
        form.add(label);

        JTextField field = new JTextField();
        form.add(field);
        int Contadorsel = selecciones.length;
        JTextArea Cantidad_total_sel = new JTextArea();
        Font font = new Font("Arial", Font.BOLD, 16);
        Cantidad_total_sel.setFont(font);
        Cantidad_total_sel.setText("Cantidad total de selecciones: " + Integer.toString(Contadorsel));

        form.add(Cantidad_total_sel);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JButton buscar = new JButton();
        buscar.setText("Buscar");
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String valorBusqueda = field.getText();
                filtrarSelecciones(valorBusqueda);
            }
        });
        panelBotones.add(buscar);

        JButton limpiar = new JButton();
        limpiar.setText("Ver Todos");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pintarTablaSelecciones();
            }
        });
        panelBotones.add(limpiar);
        form.add(panelBotones);
        form.setPreferredSize((new java.awt.Dimension(1019, 20)));

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(1020, 790)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * Función que tiene la lógica que permite leer un archivo CSV de resultados
     * y cargarlo sobre la matriz resultados que se tiene definida cómo variable
     * global. Luego de cargar los datos en la matriz, se llama la función
     * pintarTablaResultados() que se encarga de visulizar el contenido de la
     * matriz en un componente gráfico de tabla
     */
    public void cargarFileResultados() {

        JFileChooser cargarFile = new JFileChooser();
        cargarFile.showOpenDialog(cargarFile);

        Scanner entrada = null;
        try {
            // Se obtiene la ruta del archivo seleccionado
            String ruta = cargarFile.getSelectedFile().getAbsolutePath();

            // Se obtiene el archivo y se almancena en la variable f
            File f = new File(ruta);
            entrada = new Scanner(f);

            // Se define las dimensiones de la matriz de selecciones
            resultados = new String[48][7];
            entrada.nextLine();

            int i = 0;
            // Se iteran cada una de las líneas del archivo
            while (entrada.hasNext()) {
                System.out.println(i);
                String line = entrada.nextLine();
                String[] columns = line.split(",");

                for (int j = 0; j < columns.length; j++) {
                    resultados[i][j] = columns[j];
                }
                i++;
            }

            pintarTablaResultados();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    /**
     * Función que se encarga de pintar la clasificadosUnSoloGrupo con la
     * información de los resultados que fue cargada previamente La
     * clasificadosUnSoloGrupo tiene definido un encabezado con las siguentes
     * columnas: {"Grupo","Local", "Visitante", "Continente L", "Continente V",
     * "Goles L", "Goles V"} Columnas que se corresponden son la información que
     * fue leida desde el archivo csv
     */
    public void pintarDetalleResultados(String[][] resultados) {

        String[] columnNames = {"Grupo", "Local", "Visitante", "Continente L", "Continente V", "Goles L", "Goles V"};
        JTable table = new JTable(resultados, columnNames);
        table.setRowHeight(30);
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(4, 1, 0, 0));
        JLabel label = new JLabel();
        label.setText("Busqueda de Resultados");
        form.add(label);
        JTextField field = new JTextField();
        form.add(field);
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));
        JButton buscar = new JButton();
        buscar.setText("Buscar");
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Aca estamos");
                String valorBusqueda = field.getText();
                filtrarResultados(valorBusqueda);

            }
        });
        panelBotones.add(buscar);

        JButton limpiar = new JButton();
        limpiar.setText("Ver Todos");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                contador3++;
                pintarTablaResultados();
            }
        });
        panelBotones.add(limpiar);

        form.add(panelBotones);
        form.setPreferredSize((new java.awt.Dimension(310, 20)));

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(1010, 790)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * Función que permite darle estilos y agregar los componentes gráficos del
     * contendor de la parte derecha de la interfaz, dónde se visulaiza de
     * manera dinámica el contenido de cada una de las funciones que puede
     * realizar el usuario sobre la aplicación.
     */
    private void pintarPanelDerecho() {

        // Define las dimensiones del panel
        jPanelMain.setPreferredSize((new java.awt.Dimension(1020, 900)));
        jPanelMain.setMaximumSize(jPanelLabelTop.getPreferredSize());

        getContentPane().add(jPanelRight, java.awt.BorderLayout.CENTER);
        jPanelRight.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelRight.add(jPanelLabelTop, BorderLayout.LINE_START);
        jPanelRight.add(jPanelMain);
        jPanelRight.setPreferredSize((new java.awt.Dimension(1020, 900)));
        jPanelRight.setMaximumSize(jPanelRight.getPreferredSize());
    }

    /**
     * Función que permite pinta la barra azul del contenedor de contenidos.
     * Barra azul que permite indicar en que sección que se encuentra navegando
     * el usuario.
     */
    private void pintarLabelTop() {
        jLabelTop = new JLabel();
        jLabelTop.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabelTop.setForeground(new java.awt.Color(241, 241, 241));
        jLabelTop.setText("Home");

        JLabel vacioTopLabel = new JLabel();
        jPanelLabelTop.setLayout(new BorderLayout(15, 0));
        jPanelLabelTop.add(vacioTopLabel, BorderLayout.WEST);
        jPanelLabelTop.setBackground(new java.awt.Color(51, 0, 153));
        jPanelLabelTop.add(jLabelTop, BorderLayout.CENTER);
        jPanelLabelTop.setPreferredSize((new java.awt.Dimension(1019, 150)));
        jPanelLabelTop.setMaximumSize(jPanelLabelTop.getPreferredSize());
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIManual().setVisible(true);
            }
        });
    }
}
