package com.wk.task1.controller;

import com.wk.task1.converter.Converter;
import com.wk.task1.service.impl.ClientServiceImpl;
import com.wk.task1.util.SettingReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет который имеет гет запрос. В зависимости от установленных настройках выдает XML или JSON
 * @author Denis Khalaev
 */

public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        if (SettingReader.getInstance().getSetting("settingXMLOrJSON")) {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(Converter.convertClientToJSON(new ClientServiceImpl().getAllClientDTO()));
        } else {
            response.setContentType("text/xml");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(Converter.convertClientToXML(new ClientServiceImpl().getAllClientDTO()));
        }

    }
}
