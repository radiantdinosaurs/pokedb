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
public class TableSortFilter extends JFrame {

    private JTextField searchBox = null;
    private TableRowSorter<TableModel> sorter;

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
            String searchTerm = searchBox.getText();
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm,0));
            sorter.setSortKeys(null);
        } catch(java.util.regex.PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}