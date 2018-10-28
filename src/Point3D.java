/*
The Point3D class contains constructors to create Point3D objects, public
accessors for private variables and methods to find the distance between Point3D
objects
*/
class Point3D {
    // Declare x, y, and z as private variables so that only this class is able
    // to modify
    private double x;
    private double y;
    private double z;

    // No-arg constructor which creates an object with default coordinates
    // of 0, 0, 0.
    public Point3D() {
        // Initialise x, y, and z
        x = 0;
        y = 0;
        z = 0;
    }

    // Constructor which passes three arguments to create an object
    public Point3D(double x, double y, double z) {
        // Initialise x, y and z with the three arguments passed
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Public accessor to return x value
    public double getX() {
        return this.x;
    }

    // Public accessor to return y value
    public double getY() {
        return this.y;
    }

    // Public accessor to return z value
    public double getZ() {
        return this.z;
    }

    // Method to find the distance from the current object to a point passed in
    // the arguments
    public double distance(double x, double y, double z) {
        // Declare variables
        double differenceX, differenceY, differenceZ;
        // Assign differenceX/Y/Z with (thisobject.x/y/z - argument.x/y/z)
        differenceX = this.x - x;
        differenceY = this.y - y;
        differenceZ = this.z - z;
        // Perform the distance formula and return the outcome
        return Math.sqrt(differenceX*differenceX + differenceY*differenceY
                + differenceZ*differenceZ);
    }

    // Method to find the distance from the current object to a second object
    // passed in the arguments
    public double distance(Point3D point) {
        // Declare variables
        double differenceX, differenceY, differenceZ;
        // Assign differenceX/Y/Z with (thisobject.x/y/z - argument.x/y/z)
        differenceX = this.x - point.x;
        differenceY = this.y - point.y;
        differenceZ = this.z - point.z;
        // Perform the distance formula and return the outcome
        return Math.sqrt(differenceX * differenceX + differenceY * differenceY
                + differenceZ * differenceZ);
    }
}

// Class that will be used to test Point3D and all of its methods
class TestPoint3D {

    public static void main(String[] args) {
        // Use no-arg constructor to create new object "one"
        Point3D one = new Point3D();

        // Print object one's coordinates using public accessors
        System.out.println("Point 1 at: " + one.getX() + ", " + one.getY() + ", " +
                one.getZ());
        // Print a blank line
        System.out.println("");

        // Create new object "two" by passing coordinates as arguments
        Point3D two = new Point3D(1.0, 2.0, 3.0);

        // Print object two's coordinates using public accessors
        System.out.println("Point 2 at: " + two.getX() + ", " + two.getY() + ", "
                + two.getZ());
        // Print a blank line
        System.out.println("");

        // Create new object "three" by passing coordinates as arguments
        Point3D three = new Point3D(2.0, 3.0, -1.0);

        // Print object three's coordinates using public accessors
        System.out.println("Point 3 at: " + three.getX() + ", " + three.getY() + ", "
                + three.getZ());
        // Print a blank line
        System.out.println("");

        // Calculate the distance between object one and two by calling
        // .distance() method and print the outcome
        System.out.println("Point 1 to 2: " + one.distance(two));
        // Print a blank line
        System.out.println("");

        // Calculate the distance between object two and three by calling
        // .distance() method and print the outcome
        System.out.println("Point 2 to 3: " + two.distance(three));
        // Print a blank line
        System.out.println("");

        // Calculate the distance between object three and one by calling
        // .distance() method and print the outcome
        System.out.println("Point 3 to 1: " + three.distance(one));
        // Print a blank line
        System.out.println("");

        // Calculate the distance between object two and (1, 1, 1) by calling
        // .distance() method, passing the arguments and print the outcome
        System.out.println("Point 2 to (1,1,1): " + two.distance(1, 1, 1));
        // Print a blank line
        System.out.println("");
        // Declare and create poin

        // Declare and create pointArray
        Point3D[] pointArray = createPointArray();

        // Call max() method passing pointArray as an argument
        max(pointArray);

        // Call min() method passing pointArray as an argument
        min(pointArray);

    }

    // This method contructs a new array using random points and returns the
    // array when called
    public static Point3D[] createPointArray() {
        // Create new array of 10 Point3D objects called pointArray
        Point3D[] pointArray = new Point3D[10];

        // For loop to increment through the array
        for (int i = 0; i < pointArray.length; i++) {
            // Call randomPoint() method to populate the points of pointArray[i]
            pointArray[i] = new Point3D(randomPoint(), randomPoint(),
                    randomPoint());
        }

        // Return array
        return pointArray;
    }

    // This method well create a random number between 0 and 10 and return that
    // number when called
    public static double randomPoint() {
        // Declare and initialise point variable with a random number between
        // 0 and 10
        double point = Math.random() * 10;

        // Return point
        return point;
    }

    // This method receives an array of 3D points and then searches the array
    // to find the two points which are farthest away from eachother
    public static void max(Point3D[] pointArray) {
        // Declare and initialise max variable with Double.NEGATIVE_INFINITY so
        // that distance will always initially be greater than max
        double max = Double.NEGATIVE_INFINITY;

        // Initialise one and two variables
        int one = 0;
        int two = 0;

        // Declare distance variable
        double distance;

        // For loop to increment the first point
        for (int i = 0; i < pointArray.length; i++)

            // For loop to increment through the second point
            // Note that j = i + 1, so that we are not measuring the distance
            // between the same two points
            for (int j = i + 1; j < pointArray.length; j++) {

                // Using .distance() method find the distance between
                // pointArray[i] and pointArray[j] and assign to distance
                // variable
                distance = pointArray[i].distance(pointArray[j]);

                // If distance is greater than max
                if (distance > max) {
                    // Assign value of distance to max
                    max = distance;
                    // Assign value of i to one
                    one = i;
                    // Assign value of j to two
                    two = j;
                }
            }
        // Print the max distance along with the two points
        System.out.println("Maximum separation is " + max + " between points "
                + one + " and " + two);
    }

    // This method receives an array of 3D points and then searches the array
    // to find the two points which are closest to eachother
    public static void min(Point3D[] pointArray) {
        // Declare and initialise min variable with Double.POSITIVE_INFINITY so
        // that distance will always initially be less than min
        double min = Double.POSITIVE_INFINITY;

        // Initialise one and two variables
        int one = 0;
        int two = 0;

        // Declare distance variable
        double distance;

        // For loop to increment the first point
        for (int i = 0; i < pointArray.length; i++)

            // For loop to increment through the second point
            // Note that j = i + 1, so that we are not measuring the distance
            // between the same two points
            for (int j = i + 1; j < pointArray.length; j++) {

                // Using .distance() method find the distance between
                // pointArray[i] and pointArray[j] and assign to distance
                // variable
                distance = pointArray[i].distance(pointArray[j]);

                // If distance is less than min
                if (distance < min) {
                    // Assign value of distance to min
                    min = distance;
                    // Assign value of i to one
                    one = i;
                    // Assign value of j to two
                    two = j;
                }
            }
        //Print the min distance as well as the two points
        System.out.println("Minimum separation is " + min + " between points "
                + one + " and " + two);
    }
}