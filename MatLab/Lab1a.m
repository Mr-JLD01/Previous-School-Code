%John Luke Denny
%calculates where a projectile will hit with an unknown theta
%1/28/2020
%CSC 2262

h = 250;

x = 775;

g = 9.81;

accuracy = 1e-7;

degToRad = pi /180;
radToDeg = 180 / pi;

for(v = 75: 5 : 85)
    f = @(theta) h * cos(theta).^2 + (x / 2) * sin( 2 * theta) - (g * x^2) / (2 * v^2);
    fp = @(theta) -2 * h * cos(theta) * sin(theta) + x * cos(2 * theta);
    t = @(theta) (v * sin(theta)) / g + ((v^2 * sin(theta).^2) / g^2 + (2 * h) / g).^(1/2);
    ymax = @(theta) h + (v^2 * sin(theta).^2) / (2 * g);

    for(i = 0: 90)
        if(f(i * degToRad) == 0)
            fprintf('v0 = %2d theta = %.5f t = %.5f ymax = %.5f\n', v, i, t(i * degToRad), ymax(i * degToRad));
        else
            if(i ~= 90 && f(i * degToRad) * f((i + 1) * degToRad) < 0 ) 
                guess = (i + i + 1) / 2;
                theta = newton(f, fp, guess * degToRad, accuracy) * radToDeg;
                fprintf('v0 = %2d theta = %.5f t = %.5f ymax = %.5f\n', v, theta, t(theta * degToRad), ymax(theta * degToRad));
            end
        end
    end
    fprintf('\n');
end

