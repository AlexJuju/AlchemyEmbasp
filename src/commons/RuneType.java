package commons;

public class RuneType {
    public enum Shape{ARIES("Aries"), TAURUS("Taurus"), GEMINI("Gemini"), CANCER("Cancer"), LEO("Leo"), VIRGO("Virgo"), LIBRA("Libra"), SCORPIO("Scorpio"), SAGITTARIUS("Sagittarius"), CAPRICORN("Capricorn"), AQUARIUS("Aquarius"), PISCES("Pisces");
        private String shape;
        Shape(String shape) {
            this.shape = shape;
        }
        public String getName() {
            return shape;
        }
    }
    public enum Color{RED("Red"), BLUE("Blue"), GREEN("Green"), YELLOW("Yellow"), PINK("Pink"), ORANGE("Orange"), TEAL("Teal"), GREY("Grey");
        private String color;
        Color(String color) {
            this.color = color;
        }
        public String getName() {
            return color;
        }
    }
    public enum Type{NORMAL("Normal"), STONE("Stone");
        private String type;
        Type(String type) {
            this.type = type;
        }
        public String getName() {
            return type;
        }
    }
}
