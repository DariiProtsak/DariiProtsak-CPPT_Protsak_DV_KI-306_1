from .pistol import Pistol
from .water_pistol import WaterPistol

def main():
    # Create an instance of regular pistol
    regular_pistol = Pistol("Glock 17", 10)
    print("\n=== Pistol Information ===")
    print(regular_pistol.describe())
    
    # Load ammo and shoot
    regular_pistol.load_ammo(5)
    regular_pistol.shoot()
    regular_pistol.shoot()
    print(regular_pistol.get_stats())
    regular_pistol.unload()
    
    # Create an instance of water pistol
    water_pistol = WaterPistol("SuperSoaker", 500)
    print("\n=== Water Pistol Information ===")
    print(water_pistol.describe())
    
    # Load water and test functionality
    water_pistol.load_water(300)
    water_pistol.shoot()
    print(f"Pressure Check: {water_pistol.check_water_pressure()}")
    water_pistol.quick_burst(2)

if __name__ == "__main__":
    main()
    input("Press Enter to exit...")