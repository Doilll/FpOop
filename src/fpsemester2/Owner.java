package fpsemester2;

class Owner {

    static private String username = "Aufa";
    static private String password = "Faiq123";
    static private double pendapatan = 0;

    public static void setPendapatan(double pendapatan) {
        pendapatan = +pendapatan;
    }

    public static double getPendapatan() {
        return pendapatan;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}