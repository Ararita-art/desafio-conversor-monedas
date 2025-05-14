public record Divisas(
        String base_code,
        String target_code,
        double conversion_rate
) {
    @Override
    public String toString() {
        return String.format("Tipo de cambio: 1 %s = %.4f %s.",
                base_code, conversion_rate, target_code);
    }
}