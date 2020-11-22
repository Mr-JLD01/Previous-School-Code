% John Luke Denny
% CSC 2262
% cs226224
% Lab 7

%Calculates and graphs differential equations using eigenvectors and
%eigenvalues in both the real numbers and imaginary

t = 0: .001: 16;

m1 = .4;
m2 = .7;
m3 = .7;
m4 = .2;
m5 = .6;
m6 = .4;

k1 = 3.9;
k2 = 3.2;
k3 = 2.2;
k4 = 2.7;
k5 = 1.3;
k6 = 4.9;
k7 = 4.4;

c1 = .016;
c2 = .036;
c3 = .028;
c4 = .014;
c5 = .032;
c6 = .024;
c7 = .012;

A11 = [ 0 0 0 0 0 0;

        0 0 0 0 0 0;

        0 0 0 0 0 0;
        
        0 0 0 0 0 0;

        0 0 0 0 0 0;

        0 0 0 0 0 0];

A12 = [ 1 0 0 0 0 0;

        0 1 0 0 0 0;

        0 0 1 0 0 0;
        
        0 0 0 1 0 0;

        0 0 0 0 1 0;

        0 0 0 0 0 1];

A21 = [ -(k1 + k2)/m1   k2/m1           0               0               0               0;
        k2/m2           -(k2 + k3)/m2   k3/m2           0               0               0;
        0               k3/m3           -(k3 + k4)/m3   k4/m3           0               0;
        0               0               k4/m4           -(k4 + k5)/m4   k5/m4           0;
        0               0               0               k5/m5           -(k5 + k6)/m5   k6/m5;
        0               0               0               0               k6/m6           -(k6 + k7)/m6];
    
A22 = [ -(c1 + c2)/m1   c2/m1           0               0               0               0;
        c2/m2           -(c2 + c3)/m2   c3/m2           0               0               0;
        0               c3/m3           -(c3 + c4)/m3   c4/m3           0               0;
        0               0               c4/m4           -(c4 + c5)/m4   c5/m4           0;
        0               0               0               c5/m5           -(c5 + c6)/m5   c6/m5;
        0               0               0               0               c6/m6           -(c6 + c7)/m6 ];

A = [A11 A12;

    A21 A22];

[eigvec, eigval] = eig(A);

linex = [0 16];
liney = [0 0];
titles(1, :) = 'Lab 7, Figure 1';
titles(2, :) = 'Lab 7, Figure 2';
titles(3, :) = 'Lab 7, Figure 3';
titles(4, :) = 'Lab 7, Figure 4';
titles(5, :) = 'Lab 7, Figure 5';
titles(6, :) = 'Lab 7, Figure 6';

n=0;
for(k = 11:-2:1)
    n = n + 1;
    
    alpha = real( eigval(k,k) );
    beta = imag( eigval(k,k) );
    omega = sqrt( alpha^2 + beta^2 );
    zeta = -alpha/omega;

    w = omega * sqrt( 1 - zeta^2 );

    a1 = real( eigvec(1,k) );
    b1 = imag( eigvec(1,k) );

    a2 = real( eigvec(2,k) );
    b2 = imag( eigvec(2,k) );

    a3 = real( eigvec(3,k) );
    b3 = imag( eigvec(3,k) );

    a4 = real( eigvec(4,k) );
    b4 = imag( eigvec(4,k) );

    a5 = real( eigvec(5,k) );
    b5 = imag( eigvec(5,k) );

    a6 = real( eigvec(6,k) );
    b6 = imag( eigvec(6,k) );
    
    x1 = 2 * exp(alpha*t) .* ( a1*cos(w*t) + b1*sin(w*t) );
    x2 = 2 * exp(alpha*t) .* ( a2*cos(w*t) + b2*sin(w*t) );
    x3 = 2 * exp(alpha*t) .* ( a3*cos(w*t) + b3*sin(w*t) );
    x4 = 2 * exp(alpha*t) .* ( a4*cos(w*t) + b4*sin(w*t) );
    x5 = 2 * exp(alpha*t) .* ( a5*cos(w*t) + b5*sin(w*t) );
    x6 = 2 * exp(alpha*t) .* ( a6*cos(w*t) + b6*sin(w*t) );
    
    b = [abs(b1), abs(b2), abs(b3), abs(b4), abs(b5), abs(b6)];
    [minAmp, maxAmp] = minMax(b);
    f = w / (2*pi);
    
    fprintf('Mode %1.0f:   Freqency = %.5f  Max Amplitude = %.5f  Min Amplitude = %.5f\n', n, f, maxAmp, minAmp);
    
    figure(n);
    plot(t,x1,'b', t,x2,'r',t,x3,'g', t,x4,'k',t,x5,'m', t,x6,'c',linex,liney,'k');
    axis([0 16 -.8 .8]);
    
    set(gca,'xtick',0:2:16);
    set(gca,'ytick',-.8:.2:.8);
    
    xlabel('t');
    ylabel('x1(blue), x2(red), x3(green), x4(black), x5(magenta), x6(cyan)');
    
    title(titles(n,:));
    
end

function [min, max] = minMax(array)  
    min = array(1);
    max = array(1);
    for(i = 2:6)
        if(min > array(i))
            min = array(i);
        elseif(max < array(i))
            max = array(i);
        end
    end
end