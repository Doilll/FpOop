package fpsemester2;

class Owner {

    static private String username = "Aufa";
    static private String password = "Faiq123";
    static int pendapatan = 0;

    public void setPendapatan(int pendapatan) {
        pendapatan = +pendapatan;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}