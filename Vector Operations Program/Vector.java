public class Vector {

    //One array member of double type
    private double[] components;

    //Constructor (strictly 2D or 3D)
    public Vector(double[] components) throws VectorException {

        if (components.length != 2 && components.length != 3) {
            throw new VectorException("Vector must be strictly 2D or 3D.");
        }

        this.components = components.clone(); // defensive copy
    }

    //Addition
    public Vector add(Vector v1) throws VectorException {

        if (this.components.length != v1.components.length) {
            throw new VectorException("Dimensions must match.");
        }

        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] + v1.components[i];
        }

        return new Vector(result);
    }

    //Subtraction
    public Vector subtract(Vector v1) throws VectorException {

        if (this.components.length != v1.components.length) {
            throw new VectorException("Dimensions must match.");
        }

        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] - v1.components[i];
        }

        return new Vector(result);
    }

    //Dot Product
    public double dotProduct(Vector v1) throws VectorException {

        if (this.components.length != v1.components.length) {
            throw new VectorException("Dimensions must match.");
        }

        double sum = 0;

        for (int i = 0; i < components.length; i++) {
            sum += this.components[i] * v1.components[i];
        }

        return sum;
    }

    //Print Vector
    public void printVector() {

        System.out.print("(");

        for (int i = 0; i < components.length; i++) {
            System.out.print(components[i]);

            if (i < components.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(")");
    }
}