package main;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import controller.HttpManController;
import model.ResponseHandlerFactory;

import javax.swing.*;
import java.net.URLConnection;

public class HttpManWindowFactory implements ToolWindowFactory {
    private JPanel httpManWindowContent;
    private JTextField urlText;
    private JComboBox methodCombo;
    private JTextArea resultTextArea;
    private JButton goBtn;
    private JTable headerTable;
    private JPanel bodyPanel;
    private JPanel headersPanel;
    private JTabbedPane resultTabPane;

    public JTable getHeaderTable() {
        return headerTable;
    }

    public void setHeaderTable(JTable headerTable) {
        this.headerTable = headerTable;
    }

    public JPanel getHeadersPanel() {
        return headersPanel;
    }

    public void setHeadersPanel(JPanel headersPanel) {
        this.headersPanel = headersPanel;
    }

    public JTabbedPane getResultTabPane() {
        return resultTabPane;
    }

    public void setResultTabPane(JTabbedPane resultTabPane) {
        this.resultTabPane = resultTabPane;
    }

    public JTextField getUrlText() {
        return urlText;
    }

    public void setUrlText(JTextField urlText) {
        this.urlText = urlText;
    }

    public JComboBox getMethodCombo() {
        return methodCombo;
    }

    public void setMethodCombo(JComboBox methodCombo) {
        this.methodCombo = methodCombo;
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }

    public void setResultTextArea(JTextArea resultTextArea) {
        this.resultTextArea = resultTextArea;
    }

    public JButton getGoBtn() {
        return goBtn;
    }

    public void setGoBtn(JButton goBtn) {
        this.goBtn = goBtn;
    }


    public HttpManWindowFactory() {
        resultTabPane.setVisible(false);
        URLConnection.setContentHandlerFactory(new ResponseHandlerFactory());
        HttpManController controller = new HttpManController(this);
    }

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(httpManWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }


    private void createUIComponents() {

    }
}
