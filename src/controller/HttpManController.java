package controller;


import main.HttpManWindowFactory;
import model.HttpMethods;
import model.HttpRequest;
import model.HttpResponse;
import model.ResponseHeaderTableModel;
import services.RequestService;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class HttpManController {
    private HttpManWindowFactory httpManWindowFactory;
    private RequestService requestService;

    public HttpManController(HttpManWindowFactory windowFactory) {
        httpManWindowFactory = windowFactory;
        requestService = new RequestService();
        bindViewModels();
        bindActions();
    }

    private void bindViewModels() {
        httpManWindowFactory.getMethodCombo().setModel(new DefaultComboBoxModel<HttpMethods>(HttpMethods.values()));
    }

    private void bindActions() {
        httpManWindowFactory.getGoBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetView();
                HttpMethods selectedMethod = (HttpMethods) httpManWindowFactory.getMethodCombo().getSelectedItem();
                try {
                    URL url = new URL(httpManWindowFactory.getUrlText().getText());
                    HttpRequest request = new HttpRequest(url, selectedMethod);
                    HttpResponse response = requestService.processRequest(request);
                    httpManWindowFactory.getResultTabPane().setVisible(true);
                    httpManWindowFactory.getResultTextArea().append(response.getReponseBody());
                    populateResponseHeaders(response);
                } catch (MalformedURLException urlException) {
                    System.out.println(urlException.getMessage().toString());
                }

            }
        });
    }

    private void populateResponseHeaders(HttpResponse response){
        httpManWindowFactory.getHeaderTable().setModel(new ResponseHeaderTableModel(response.getHeaders()));
    };

    private void resetView(){
        httpManWindowFactory.getResultTextArea().setText(null);
    }
}
