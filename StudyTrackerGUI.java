import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;

// Class to hold the Study Log details
class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate date, String subject, double duration, String description)
    {
        this.Date = date;
        this.Subject = subject;
        this.Duration = duration;
        this.Description = description;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescription()
    {
        return Description;
    }
}

// GUI class for Study Tracker
class StudyTrackerGUI extends JFrame
{
    private ArrayList<StudyLog> Database = new ArrayList<>();
    private DefaultTableModel TableModel;

    public StudyTrackerGUI()
    {
        setTitle("Marvellous Study Tracker");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table to display logs
        TableModel = new DefaultTableModel(new String[]{"Date", "Subject", "Duration", "Description"}, 0);
        JTable TableObj = new JTable(TableModel);

        // Input fields
        JTextField TxtSubject = new JTextField(15);
        JTextField TxtDuration = new JTextField(5);
        JTextArea TxtDescription = new JTextArea(3, 15);

        JButton BtnAdd = new JButton("Add Log");
        JButton BtnSummaryDate = new JButton("Summary by Date");
        JButton BtnSummarySubject = new JButton("Summary by Subject");
        JButton BtnExport = new JButton("Export to CSV");
        JButton BtnExit = new JButton("Exit");

        // Panel for inputs
        JPanel PanelInput = new JPanel();
        PanelInput.add(new JLabel("Subject:"));
        PanelInput.add(TxtSubject);
        PanelInput.add(new JLabel("Duration (hrs):"));
        PanelInput.add(TxtDuration);
        PanelInput.add(new JLabel("Description:"));
        PanelInput.add(new JScrollPane(TxtDescription));
        PanelInput.add(BtnAdd);

        // Panel for buttons
        JPanel PanelButtons = new JPanel();
        PanelButtons.add(BtnSummaryDate);
        PanelButtons.add(BtnSummarySubject);
        PanelButtons.add(BtnExport);
        PanelButtons.add(BtnExit);

        // Layout setup
        setLayout(new BorderLayout());
        add(PanelInput, BorderLayout.NORTH);
        add(new JScrollPane(TableObj), BorderLayout.CENTER);
        add(PanelButtons, BorderLayout.SOUTH);

        // Action for adding log
        BtnAdd.addActionListener(e ->
        {
            try
            {
                String subject = TxtSubject.getText().trim();
                double duration = Double.parseDouble(TxtDuration.getText().trim());
                String description = TxtDescription.getText().trim();
                LocalDate date = LocalDate.now();

                if(subject.isEmpty() || description.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }

                StudyLog logObj = new StudyLog(date, subject, duration, description);
                Database.add(logObj);

                TableModel.addRow(new Object[]{date, subject, duration, description});

                TxtSubject.setText("");
                TxtDuration.setText("");
                TxtDescription.setText("");

                JOptionPane.showMessageDialog(this, "Log added successfully!");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Invalid input for duration.");
            }
        });

        // Summary by Date
        BtnSummaryDate.addActionListener(e ->
        {
            if(Database.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Database is empty.");
                return;
            }

            TreeMap<LocalDate, Double> MapObj = new TreeMap<>();

            for(StudyLog log : Database)
            {
                MapObj.put(log.getDate(), MapObj.getOrDefault(log.getDate(), 0.0) + log.getDuration());
            }

            StringBuilder sb = new StringBuilder();
            for(LocalDate date : MapObj.keySet())
            {
                sb.append(date).append(" : ").append(MapObj.get(date)).append(" hrs\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString(), "Summary by Date", JOptionPane.INFORMATION_MESSAGE);
        });

        // Summary by Subject
        BtnSummarySubject.addActionListener(e ->
        {
            if(Database.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Database is empty.");
                return;
            }

            TreeMap<String, Double> MapObj = new TreeMap<>();

            for(StudyLog log : Database)
            {
                MapObj.put(log.getSubject(), MapObj.getOrDefault(log.getSubject(), 0.0) + log.getDuration());
            }

            StringBuilder sb = new StringBuilder();
            for(String subject : MapObj.keySet())
            {
                sb.append(subject).append(" : ").append(MapObj.get(subject)).append(" hrs\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString(), "Summary by Subject", JOptionPane.INFORMATION_MESSAGE);
        });

        // Export to CSV
        BtnExport.addActionListener(e ->
        {
            if(Database.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Database is empty.");
                return;
            }

            try(FileWriter fw = new FileWriter("MarvellousStudy.csv"))
            {
                fw.write("Date,Subject,Duration,Description\n");

                for(StudyLog log : Database)
                {
                    fw.write(log.getDate() + "," + log.getSubject().replace(",", " ") + "," +
                             log.getDuration() + "," + log.getDescription().replace(",", " ") + "\n");
                }

                JOptionPane.showMessageDialog(this, "Exported to MarvellousStudy.csv successfully!");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error exporting CSV.");
            }
        });

        // Exit application
        BtnExit.addActionListener(e -> System.exit(0));
    }
}

// Starter class
class Program557GUI
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new StudyTrackerGUI().setVisible(true);
        });
    }
}
