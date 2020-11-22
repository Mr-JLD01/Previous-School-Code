% John Luke Denny
% CSC 2262
% cs226224
% Lab 8b

%Calculates the mass via the integral of a function with two variables

a = 2;
b = 4;

g = @(x) (x.^2 .* (x - 2).^3) ./ (x.^2 + 3*x + 4);
h = @(x) ((x + 1).^2 + 3) ./ (1 + (x - 1) .* sin(pi/4 * (x - 2)));
f = @(x,y) (y.^2 .* cos(x + y)) ./ (x + 2*y + 1) + y.^3 .* exp((2*x + 3*y) ./ (x + y + 1));

mass = quad2d(f,a,b,g,h,'RelTol',1e-7,'AbsTol',1e-7);

fprintf('mass = %.5f\n',mass);