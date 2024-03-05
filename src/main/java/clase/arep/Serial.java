package clase.arep;

import java.lang.reflect.Method;

public class Serial {
    
    public static String generateRespone(String res){
        String name = res.split("\\(")[0];
        Double data = Double.parseDouble(res.split("\\(")[1].split("\\)")[0]);
        System.out.println(data + "<-----------");
        Object resp = null;
        Class xd = Math.class;
        Method a;
        String response = "";
        try {
            a = xd.getMethod(name, Double.TYPE);
            resp = a.invoke(null, data);
            System.out.println(a.getName());
            response = Double.toString((Double)resp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return response;
    }

    public static boolean palindromo(String palabra){
        System.out.println(palabra);
        int i = 0, j = palabra.length() - 1;
        while (i < j) {
            if (palabra.charAt(i) != palabra.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static Double vector(String data){
        String[] xd = data.split(",");
        int p1 = Integer.parseInt(xd[0]); 
        int p2 = Integer.parseInt(xd[1]);
        Double res = Math.sqrt(Math.pow(p1,2) + (Math.pow(p2,2)));
        return res;
    }
}
