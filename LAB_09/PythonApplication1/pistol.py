class Pistol:
    """
    Base class for representing a pistol.
    """
    def __init__(self, model, ammo_capacity):
        """
        Initialize the pistol.
        
        Args:
            model (str): Pistol model
            ammo_capacity (int): Magazine capacity
        """
        self._model = model
        self._ammo_capacity = ammo_capacity
        self._ammo_loaded = 0
        self._total_shots = 0
    
    def load_ammo(self, amount):
        """Loads the pistol with ammunition."""
        if self._ammo_loaded + amount <= self._ammo_capacity:
            self._ammo_loaded += amount
            print(f"{amount} bullets loaded. Current: {self._ammo_loaded}/{self._ammo_capacity}.")
        else:
            print("Magazine capacity exceeded!")
    
    def shoot(self):
        """Fires a bullet if at least one is loaded."""
        if self._ammo_loaded > 0:
            self._ammo_loaded -= 1
            self._total_shots += 1
            print(f"Shot fired! Bullets remaining: {self._ammo_loaded}")
        else:
            print("No bullets to shoot.")
    
    def describe(self):
        """Returns pistol description."""
        return f"Model: {self._model}\nMagazine capacity: {self._ammo_capacity}\nCurrently loaded: {self._ammo_loaded}"
    
    def get_stats(self):
        """Returns shooting statistics."""
        return f"Total shots fired: {self._total_shots}\nReloads needed: {self._total_shots // self._ammo_capacity}"
    
    def unload(self):
        """Safely unloads all ammunition from the pistol."""
        if self._ammo_loaded > 0:
            unloaded = self._ammo_loaded
            self._ammo_loaded = 0
            print(f"Safely unloaded {unloaded} bullets.")
        else:
            print("Magazine is already empty.")