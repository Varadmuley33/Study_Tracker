import javax.swing.*;

public class StudyTrackerGUImain
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new StudyTrackerGUI().setVisible(true);
        });
    }
}