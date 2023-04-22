#define HIGHP

#define C2 vec3(224.0, 84.0, 56.0) / 255.0
#define C1 vec3(249.0, 143.0, 74.0) / 255.0
#define NSCALE 40.0

uniform sampler2D u_texture;
uniform sampler2D u_noise;

uniform vec2 u_campos;
uniform vec2 u_resolution;
uniform float u_time;

varying vec2 v_texCoords;

void main() {
    vec2 c = v_texCoords.xy;
    vec2 coords = vec2(c.x * u_resolution.x + u_campos.x, c.y * u_resolution.y + u_campos.y);

    float btime = u_time / 800.0;
    float wave = abs(sin(coords.x * 2 + coords.y) + 0.4 * sin(2.5 * coords.x) + 0.3 * sin(3.0 * coords.y)) / 20.0;
    float noise = wave + (texture2D(u_noise, vec2(coords.x, coords.y / 4.0) / NSCALE + vec2(btime) * vec2(0.3, -0.5)).a + texture2D(u_noise, vec2(coords.x, coords.y / 3.0) / NSCALE + vec2(btime * 1.3) * vec2(0.5, 0.1)).a) / 2.2;
    vec4 color = texture2D(u_texture, c);

    if (noise < 0.51 && noise < 0.58) {
        color.rgb = C2;
    } else if (noise > 0.62 && noise < 0.74) {
        color.rgb = C1;
    }

    gl_FragColor = color;
}