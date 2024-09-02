package org.pointOfSale;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class sellOneItemTest {

    private Display display;
    private Sale sale;
    
    @Before
    public void setUp() throws Exception {
          display = new Display();
          sale = new Sale(display, new HashMap<String, String>(){{
            put("12345", "7.95");
            put("23456", "12.50");
        }});
    }

    @Test
    public void productFound() throws Exception {
        sale.onBarcode("12345");
        assertEquals("7.95", display.getText());
    }

    @Test
    public void anotherProductFound() throws Exception {
        sale.onBarcode("23456");
        assertEquals("12.50", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {
        sale.onBarcode("99999");
        assertEquals("Product not found for 99999", display.getText());
    }

    @Test
    public void emptyBarcode() throws Exception {
        final Sale sale = new Sale(display,null);

        sale.onBarcode("");
        assertEquals("Scanning error : empty barcode", display.getText());
    }

    public class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void displayPrice(String priceAsText) {
            display.setText(priceAsText);
        }

        public void displayProductNotFound(String barcode) {
            display.setText("Product not found for " + barcode);
        }

        public void displayBarcodeNotFound() {
            display.setText("Scanning error : empty barcode");
        }
    }

    public static class Sale {
        private Map<String, String> pricesByBarcode;
        private Display display;

        public Sale(Display display, Map<String, String>pricesByBarcode) {
            this.display = display;
            this.pricesByBarcode = pricesByBarcode;
        }

        public void onBarcode(String barcode) {

            if (("").equals(barcode))
            {
                display.displayBarcodeNotFound();
                return;
            }
            final String priceAsText = findPrice(barcode);
            if (priceAsText == null)
            {
                display.displayProductNotFound(barcode);
            }
            else
            {
                display.displayPrice(priceAsText);
            }
        }

        private boolean hasBarcode(String barcode) {
            return pricesByBarcode.containsKey(barcode);
        }

//        private void findPriceThenDisplayPrice(String barcode) {
//            final String priceAsText = findPrice(barcode);
//            displayPrice(priceAsText);
//        }



        private String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }

    }
}
