from .pistol import Pistol

class WaterPistol(Pistol):
    """
    Class for representing a water pistol, inherited from Pistol.
    """
    def __init__(self, model, water_capacity):
        """
        Initialize the water pistol.
        
        Args:
            model (str): Water pistol model
            water_capacity (int): Water capacity in ml
        """
        super().__init__(model, ammo_capacity=0)  # Water pistol has no bullets
        self._water_capacity = water_capacity
        self._water_loaded = 0
        self._refill_count = 0
    
    def load_water(self, amount):
        """Loads the pistol with water."""
        if self._water_loaded + amount <= self._water_capacity:
            self._water_loaded += amount
            self._refill_count += 1
            print(f"{amount} ml of water loaded. Current: {self._water_loaded}/{self._water_capacity} ml.")
        else:
            print("Water tank capacity exceeded!")
    
    def shoot(self):
        """Shoots water if water is loaded."""
        if self._water_loaded > 0:
            self._water_loaded -= 1
            print(f"Water shot! Water remaining: {self._water_loaded} ml")
        else:
            print("No water to shoot.")
    
    def describe(self):
        """Returns extended description of the water pistol."""
        base_description = super().describe()
        return f"{base_description}\nWater capacity: {self._water_capacity} ml\nWater loaded: {self._water_loaded} ml"
    
    def check_water_pressure(self):
        """Simulates checking water pressure based on how full the tank is."""
        fill_percentage = (self._water_loaded / self._water_capacity) * 100
        if fill_percentage > 75:
            return "High pressure - Maximum range!"
        elif fill_percentage > 25:
            return "Medium pressure - Normal range"
        else:
            return "Low pressure - Limited range"
    
    def quick_burst(self, duration):
        """
        Shoots multiple water bursts based on duration (in seconds).
        Each second uses 10ml of water.
        """
        water_needed = duration * 10
        if self._water_loaded >= water_needed:
            self._water_loaded -= water_needed
            print(f"Burst shot for {duration} seconds!")
            print(f"Used {water_needed}ml of water. Remaining: {self._water_loaded}ml")
        else:
            print(f"Not enough water! Need {water_needed}ml but only have {self._water_loaded}ml")