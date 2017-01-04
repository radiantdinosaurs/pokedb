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
 * Makes a JTable to display database contents for user to filter through
 * @author radiantdinosaurs
 */
public class PokemonStatsTableWithSearchView extends JFrame {

    private JTextField searchBox = null;
    private TableRowSorter<TableModel> sorter;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int fontSize = DimensionUtil.computerBaseFontSize(screenSize.width, screenSize.height);
    private Font font = new Font("Segoe UI", Font.PLAIN, fontSize);

    public PokemonStatsTableWithSearchView() {
        getContentPane().add(new JScrollPane(getPokemonStatsTable(getPokemonDefaultTableModel())));
        JPanel panel = new JPanel();
        panel.setFont(font);
        panel.add(getPokemonSearchLabel());
        panel.add(getPokemonSearchBox());
        getContentPane().add(panel, BorderLayout.SOUTH);
        setSize(new Dimension(screenSize.width/2, screenSize.height/2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private DefaultTableModel getPokemonDefaultTableModel() {
        DatabaseReader dr = new DatabaseReader();
        return new DefaultTableModel(dr.dataOfPokemonForTable(),dr.columnsOfPokemonForTable());
    }

    private JTable getPokemonStatsTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setRowHeight(fontSize * 2);
        table.setFont(font);
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        return table;
    }

    private JLabel getPokemonSearchLabel() {
        JLabel jlabel = new JLabel("Search for Pokemon Name: ");
        jlabel.setFont(font);
        return jlabel;
    }

    private JTextField getPokemonSearchBox() {
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
        return searchBox;
    }

    /**
     * Searches through the JTable for the search term
     */
    private void search() {
        try {
            String searchTerm = searchBox.getText().trim();
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm,0));
            sorter.setSortKeys(null);
        } catch(java.util.regex.PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}