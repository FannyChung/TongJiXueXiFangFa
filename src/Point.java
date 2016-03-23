import java.util.ArrayList;

public class Point {

		ArrayList<Double> x = new ArrayList<>();
		/**
		 * 取值1或-1
		 */
		int y;

		public Point(ArrayList<Double> x, int y) {
			setX(x);
			setY(y);
		}
		public Point(double[] args) {
			int j=args.length;
			ArrayList<Double> xArrayList = new ArrayList<>(j);
			for (int i = 0; i < j; i++) {
				xArrayList.add(args[i]);
			}
			setX(xArrayList);
		}
		public Point(double[] args, int y) {
			int j=args.length;
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
