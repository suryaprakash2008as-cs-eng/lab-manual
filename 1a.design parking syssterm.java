class ParkingSystem {
    // Index 1 = Big, Index 2 = Medium, Index 3 = Small
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // If there's an available slot for the given carType
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
