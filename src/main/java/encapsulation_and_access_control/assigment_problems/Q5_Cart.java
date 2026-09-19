package encapsulation_and_access_control.assigment_problems;

class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    Cart(String cartId, int maximumItems) {
        this.cartId = cartId;
        prices = new double[maximumItems];
    }

    void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}
