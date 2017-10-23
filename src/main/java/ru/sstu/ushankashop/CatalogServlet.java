package ru.sstu.ushankashop;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CatalogServlet extends HttpServlet {

    private static List<Item> ITEMS = Arrays.asList(new Item(0L,"Hat-Ushanka","Warm and Cozy", 99.99,15));

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ItemList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(new ItemList(ITEMS), resp.getOutputStream());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //todo
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
