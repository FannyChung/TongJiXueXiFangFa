import java.util.ArrayList;


/**
 * 
 */

/**
 * @author Fang
 *
 */
public class Perceptron {

	/**
	 * 学习率，0~1
	 */
	double ni;

	/**
	 * x的维数
	 */
	int j;

	double b;

	double[] a;
	boolean erro = true;

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	ArrayList<Double> w = new ArrayList<>();

	private double[][] Gram;

	private int sign(double s) {
		if (s >= 0)
			return 1;
		else {
			return -1;
		}
	}

	/**
	 * 
	 */
	public Perceptron() {
	}

	public void original(Point[] points) {
		while (erro) {
			erro = false;
			for (Point point : points) {
				double temp = b;
				temp += calculateDotProduct(point.getX(), w);
				if (point.y * temp <= 0) {
					update(point);
					erro = true;
				}
			}
		}
	}

	/**计算两个向量的点积
	 * @param x
	 * @param y
	 * @return
	 */
	private double calculateDotProduct(ArrayList<Double> x, ArrayList<Double> y) {
		double result = 0;
		for (int i = 0; i < x.size(); i++) {
			result += x.get(i) * y.get(i);
		}
		return result;
	}

	private void update(Point point) {
		for (int i = 0; i < j; i++) {
			w.set(i, w.get(i) + ni * point.y * point.getX().get(i));
		}
		b += ni * point.y;

		System.out.print(w + "\t" + b + "\t");
		for (int i = 0; i < j; i++) {
			System.out.print(w.get(i) + "x(" + (i + 1) + ")+");
		}
		System.out.println(b);
	}

	public void dual(Point[] points) {
		a = new double[points.length];
		calculateGram(points);
		while (erro) {
			erro = false;
			for (int i = 0; i < points.length; i++) {
				Point point = points[i];
				double temp = b;
				for (int j = 0; j < points.length; j++) {
					temp += a[j] * (points[j].getY()) * Gram[j][i];
				}
				updatedual(point, i, temp);
			}
		}
	}

	private void updatedual(Point point, int i, double temp) {
		if (point.getY() * temp <= 0) {
			erro = true;
			a[i] += ni;
			b += ni * point.getY();
			System.out.print((i + 1) + "\t");
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + "\t");
			}
			System.out.println(b);
		}
	}

	private void calculateGram(Point[] points) {
		Gram = new double[points.length][points.length];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				Gram[i][j] = calculateDotProduct(points[i].getX(), points[j].getX());
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Perceptron perceptron = new Perceptron();
		int j = 2;
		perceptron.setJ(j);
		int b = 0;
		perceptron.setB(b);

		double ni = 1;
		perceptron.setNi(ni);
		// test1
		// ArrayList<Double> w = new ArrayList<>(j);// 初始化为0
		// for (int i = 0; i < j; i++) {
		// w.add(0.0);
		// }
		// perceptron.setW(w);
		// perceptron.original(new Point[] { perceptron.new Point(new double[] {
		// 3, 3 }, 1),
		// perceptron.new Point(new double[] { 4, 3 }, 1), perceptron.new
		// Point(new double[] { 1, 1 }, -1) });

		// test2
		perceptron.dual(new Point[] { perceptron.new Point(new double[] { 3, 3 }, 1),
				perceptron.new Point(new double[] { 4, 3 }, 1), perceptron.new Point(new double[] { 1, 1 }, -1) });

	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public ArrayList<Double> getW() {
		return w;
	}

	public void setW(ArrayList<Double> w) {
		this.w = w;
	}

	public double getNi() {
		return ni;
	}

	public void setNi(double ni) {
		this.ni = ni;
	}

	class Point {
		ArrayList<Double> x = new ArrayList<>();
		/**
		 * 取值1或-1
		 */
		int y;

		public Point(ArrayList<Double> x, int y) {
			setX(x);
			setY(y);
		}

		public Point(double[] args, int y) {
			ArrayList<Double> xArrayList = new ArrayList<>(j);
			for (int i = 0; i < j; i++) {
				xArrayList.add(args[i]);
			}
			setX(xArrayList);
			setY(y);
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public ArrayList<Double> getX() {
			return x;
		}

		public void setX(ArrayList<Double> x) {
			this.x = x;
		}
	}
}
