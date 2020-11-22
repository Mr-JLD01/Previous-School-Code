function f = gilpin(t,uf)

A = .0012;
B = .011;
C = .0014;
D = .006;
E = .0004;
k = .45;

X = uf(1);
Y = uf(2);
Z = uf(3);

f = zeros(3,1);

f(1) = X - A*X^2 - A*k*X*Y - B*X*Z;
f(2) = Y - C*k*X*Y - A*Y^2 - A*Y*Z;
f(3) = -Z + D*X*Z + E*Y*Z;
end

