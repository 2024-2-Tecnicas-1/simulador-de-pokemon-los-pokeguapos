package simulador.logicaNegocio.batalla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;

public class BatallaForm extends javax.swing.JFrame {
    private Pokemon[] pokemones;
    private JLabel[][] labels;
    private boolean batallaFinalizada;
    private int xPos = 870;
    private int yPos = 420;
    private Timer timer;
    private JPanel pnlAtaque;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private boolean estaAtacando;

    public BatallaForm(Pokemon pokemon1, Pokemon pokemon2) {
        pokemones = new Pokemon[]{
            pokemon1,pokemon2
        };
        inicializarComponentes();
        labels = new JLabel[2][2];
        labels[0][0] = lblPokemon1;
        labels[0][1] = lblInfoPokemon1;
        labels[1][0] = lblPokemon2;
        labels[1][1] = lblInfoPokemon2;
        batallaFinalizada = false;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        estaAtacando = false;

        cargarPokemon(0);
        cargarPokemon(1);
    }

    private void cargarPokemon(int indice) {
        Pokemon pokemon = pokemones[indice];
        String nombrePokemon = pokemon.getNombre();
        String ruta = "gifs/" + nombrePokemon + ".gif";
        File archivo = new File(ruta);
        if (archivo.exists()) {
            ImageIcon icono = new ImageIcon(ruta);
            labels[indice][0].setIcon(icono);
        }
        String texto = "<html>Nombre: " + pokemon.getNombre() + " <br> Salud: " + pokemon.getSalud() + " <br>Ataque: " + pokemon.getPuntosDeAtaque() + " <br> </html>";
        labels[indice][1].setText(texto);
    }

    private void pokemonAtaca(int indiceAtaca, int indiceDefiende) {
        crearAtaque(indiceAtaca, indiceDefiende);
    }

    private void moverAtaque(int indiceAtaca) {
        int multiplicador = 1;
        if (indiceAtaca == 1) {
            multiplicador = -1;
        }
        xPos += 15 * multiplicador;
        yPos += 9 * multiplicador;
        pnlAtaque.setBounds(xPos, yPos, 100, 100);
    }

    private void reducirAtaque(int indiceAtaca, int indiceDefiende){
        double ataque = pokemones[indiceAtaca].getPuntosDeAtaque() * TipoPokemon.obtenerMultiplicadorDeDaño(pokemones[indiceAtaca].getTipo(), pokemones[indiceDefiende].getTipo());
        int nuevaVida =  pokemones[indiceDefiende].getSalud() - (int) ataque;
        pokemones[indiceDefiende].setSalud(nuevaVida);
        System.out.println("Vida de " + pokemones[indiceDefiende].getNombre() +  " es " + pokemones[indiceDefiende].getSalud());
        if(pokemones[indiceDefiende].getSalud() <= 0){
            batallaFinalizada = true;
            // Pokemon perdió
            JOptionPane.showMessageDialog(this, pokemones[indiceDefiende].getNombre() + " perdió");
        } else {
            cargarPokemon(indiceDefiende);
        }
        estaAtacando = false;
    }


    private void crearAtaque(int indiceAtaca, int indiceDefiende) {
        xPos = 200;
        yPos = 100;
        pnlAtaque = new AtaquePanel2();

        if (indiceAtaca == 1) {
            xPos = 870;
            yPos = 420;
            pnlAtaque = new AtaquePanel();
        }

        pnlAtaque.setBounds(xPos, yPos, 100, 100);
        add(pnlAtaque);
        timer = new Timer(1, new ActionListener() {
            int pasos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                moverAtaque(indiceAtaca);
                if (pasos > 44) {
                    timer.stop();
                    remove(pnlAtaque);
                    reducirAtaque(indiceAtaca, indiceDefiende);
                }
                revalidate();
                repaint();
                pasos += 1;
            }

        });
        timer.start();
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        if (false == batallaFinalizada) {
            if (!estaAtacando) {
                estaAtacando = true;
                int teclaAscii = evt.getKeyCode();

                switch (teclaAscii) {
                    case 65:
                        pokemonAtaca(0, 1);
                        break;
                    case 76:
                        pokemonAtaca(1, 0);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "La batalla ya finalizó");
        }
    }

    private void inicializarComponentes() {

        lblPokemon2 = new javax.swing.JLabel();
        lblPokemon1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInfoPokemon1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblInfoPokemon2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        lblInfoPokemon1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInfoPokemon1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInfoPokemon1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        lblInfoPokemon2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInfoPokemon2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInfoPokemon2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPokemon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lblPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(879, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(243, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblPokemon2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(250, 250, 250))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lblPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(359, Short.MAX_VALUE)))
        );

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInfoPokemon1;
    private javax.swing.JLabel lblInfoPokemon2;
    private javax.swing.JLabel lblPokemon1;
    private javax.swing.JLabel lblPokemon2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
