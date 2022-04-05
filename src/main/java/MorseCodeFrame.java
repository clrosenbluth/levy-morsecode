import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// view

public class MorseCodeFrame extends JFrame
{
    private final MorseCodePresenter presenter;

    private JTextArea english;
    private JTextArea morse;
    private JButton toEnglish;
    private JButton toMorse;

    private JPanel verticalPanel;
    private JPanel horizontalPanel;

    public MorseCodeFrame()
    {
        setTitle("Morse Code Translator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        addVerticalPanel();
        addSpace();
        addEnglish();
        addSpace();
        addMorse();
        addSpace();
        addHorizontalPanel();
        addToEnglish();
        addToMorse();

        MorseEnglishDictionary dictionary = new MorseEnglishDictionary();
        MorseCodeConverter model = new MorseCodeConverter(dictionary);
        presenter = new MorseCodePresenter(model, this);
    }

    private void addVerticalPanel()
    {
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);
    }

    private void addSpace()
    {
        verticalPanel.add(Box.createVerticalStrut(20));
    }

    private void addEnglish()
    {
        english = new JTextArea();
        english.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(english);
    }

    private void addMorse()
    {
        morse = new JTextArea();
        morse.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(morse);
    }

    private void addHorizontalPanel()
    {
        horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));
        verticalPanel.add(horizontalPanel);
    }

    private void addToEnglish()
    {
        toEnglish = new JButton("English");
        toEnglish.addActionListener(this::onToEnglishClicked);
        horizontalPanel.add(toEnglish);
    }

    private void addToMorse()
    {
        toMorse = new JButton("Morse");
        toMorse.addActionListener(this::onToMorseClicked);
        horizontalPanel.add(toMorse);
    }

    public void setEnglish(String text)
    {
        this.english.setText(text);
    }

    public void setMorse(String text)
    {
        this.morse.setText(text);
    }

    public void onToEnglishClicked(ActionEvent event)
    {
        presenter.toEnglish(morse.getText());
    }

    public void onToMorseClicked(ActionEvent event)
    {
        presenter.toMorse(english.getText());
    }

    public static void main(String[] args)
    {
        JFrame frame = new MorseCodeFrame();
        frame.setVisible(true);
    }
}
