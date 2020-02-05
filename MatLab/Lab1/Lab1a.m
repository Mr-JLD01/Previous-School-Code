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
    
    root1 = -1 ; root2 = -1;
    
    while(root1 == -1 && root2 == -1)
        for(i = 0: 90)
            if(f(i * degToRad) == 0)
                if(root1 ~= -1)
                    root2 = i;
                else
                    root1 = i;
                end
            else
                if(i ~= 90 && f(i * degToRad) * f((i + 1) * degToRad) < 0 ) 
                     guess = (i + i + 1) / 2;
                     if(root1 ~= -1)
                        root2 = newton(f, fp, guess * degToRad, accuracy) * radToDeg;
                     else
                        root1 = newton(f, fp, guess * degToRad, accuracy) * radToDeg;
                     end
                    
                end
                
            end
            
        end
    end
    fprintf('v0 = %2d theta = %.5f t = %.5f ymax = %.5f\n', v, root1, t(root1 * degToRad), ymax(root1 * degToRad));
    fprintf('v0 = %2d theta = %.5f t = %.5f ymax = %.5f\n\n', v, root2, t(root2 * degToRad), ymax(root2 * degToRad));
end

