package io.radiantdinosaurs.pokedb.gui;

import io.radiantdinosaurs.pokedb.database.DatabaseReader;
import io.radiantdinosaurs.pokedb.utils.DimensionUtil;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * TODO: the name is should be changed to something more descriptive. As it is, it's hard to guess what this JFrame is
 * displaying. Describing that would be describing the primary function of this class.
 * As you extend functionality by adding things like filter tools or a more advanced search, you would
 * have those in separate classes and have them included in this class as associated code rather than part of the name.
 *
 * For example, calling this class PokemonStatsTableWithSearchView makes it clear this class is for displaying
 * Pokemon stats in a GUI that has a search feature.
 * Once you throw in more functionality like filtering or sorting, you can rename the class to
 * PokemonStatsView and make it known to other developers that it has all this functionality by
 * having member variables or interface implementations.
 *
 * Makes a JTable to display database contents for user to filter through
 * @author radiantdinosaurs
 */
public class TableSortFilter extends JFrame {

    private JTextField searchBox = null;
    private TableRowSorter<TableModel> sorter;

    /**
     * TODO: try to avoid having long methods or constructors. Busy blocks of code are difficult to quickly grok
     * unless the reader is already familiar with the code or API.
     *
     * Try to break down your constructor and utilize member variables or method parameters to pass around
     * dependencies. For example, your JTable instance requires a DefaultTableModel instance and after it's
     * configured, is added to this JFrame instance's content pane.
     *
     * The code for all of that isn't necessarily easy to read. It would improve readability to have all of
     * that configuration done in a separate method. Something with the signature of:
     *
     * private JTable getPokemonStatsTable(DefaultTableModel tableModel);
     *
     * This method would hide away details like font size, font family, and height and width parameters,
     * which isn't quintessential to understanding what the JTable is doing (e.g. displaying Pokemon stats).
     *
     * The same thing can be said for the rest of the code here.
     *
     * - Andrew
     */
    public TableSortFilter() {

        DatabaseReader dr = new DatabaseReader();
        DefaultTableModel model = new DefaultTableModel(dr.dataOfPokemonForTable(),dr.columnsOfPokemonForTable());

        JTable table = new JTable(model);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int fontSize = DimensionUtil.computerBaseFontSize(screenSize.width, screenSize.height);
        table.setRowHeight(fontSize * 2);
        Font font = new Font("Segoe UI", Font.PLAIN, fontSize);
        table.setFont(font);

        JTableHeader header = table.getTableHeader();
        header.setFont(font);

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        getContentPane().add(new JScrollPane(table));

        JPanel panel = new JPanel();
        panel.setFont(font);

        JLabel jlabel = new JLabel("Search for Pokemon Name: ");
        jlabel.setFont(font);
        panel.add(jlabel);

        searchBox = new JTextField(30);
        searchBox.setFont(font);
        //Creating a DocumentListener for searchBox to perform live updates on queries
        searchBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });
        panel.add(searchBox);

        getContentPane().add(panel, BorderLayout.SOUTH);
        setSize(new Dimension(screenSize.width/2, screenSize.height/2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Searches through the JTable for the search term
     */
    private void search() {
        try {
            // TODO: does the TableRowSorter clean the string in any way?
            // if not, you should clean up the search box string to a "sufficient" amount.
            // Sufficient is defined by you, but at the minimum, search term strings should have
            // .trim() called on them to eliminate whitespace.
            // It's a burden to the user experience to not find Absol because they typed "Abs  " without realizing it.
            // - Andrew
            String searchTerm = searchBox.getText();
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm,0));
            sorter.setSortKeys(null);
        } catch(java.util.regex.PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}