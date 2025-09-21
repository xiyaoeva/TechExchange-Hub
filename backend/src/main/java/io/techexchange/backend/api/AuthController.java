
package io.techexchange.backend.api;

import io.techexchange.backend.auth.JwtUtil;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.getOrDefault("username", "guest");
        // demo only: no password checks
        String token = JwtUtil.generateToken(username);
        return Map.of("token", token);
    }
}
