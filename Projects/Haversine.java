public class Haversine {
    public static final double radius = 6372.8;

    public static void main(String[] args) {
      double lat1 = 53.386303237279456;
      double long1 = -6.599704743408211;
      double lat2 = 39.0366364;
      double long2 = 125.73091870000007;
      System.out.println(haversine(lat1, long1, lat2, long2));
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
      double diffLat = Math.toRadians(lat2 - lat1);
      double diffLon = Math.toRadians(lon2 - lon1);
      lat1 = Math.toRadians(lat1);
      lat2 = Math.toRadians(lat2);

      double a = Math.pow(Math.sin(diffLat/2),2)+Math.pow(Math.sin(diffLon/2),2)*Math.cos(lat1)*Math.cos(lat2);
      double c = 2 * Math.asin(Math.sqrt(a));
      return radius*c;
    }
}
