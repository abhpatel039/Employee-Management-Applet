public class Employ {

    private int e_id;
    private String name ;
    private String post ;
    private double salary;

    public Employ()
    {
        super();
    }
    public Employ(int e_id,String name,String post,double salary)
    {
        super();
        this.e_id = e_id;
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    public int getE_id()
    {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
